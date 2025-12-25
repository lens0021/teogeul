package io.github.lens0021.teogeul;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.github.lens0021.teogeul.KOKR.EngineMode;
import io.github.lens0021.teogeul.KOKR.HangulEngine;
import io.github.lens0021.teogeul.KOKR.HangulEngine.FinishComposingEvent;
import io.github.lens0021.teogeul.KOKR.HangulEngine.HangulEngineEvent;
import io.github.lens0021.teogeul.KOKR.HangulEngine.HangulEngineListener;
import io.github.lens0021.teogeul.KOKR.HangulEngine.SetComposingEvent;
import io.github.lens0021.teogeul.KOKR.preference.KeystrokePreference;
import io.github.lens0021.teogeul.KOKR.ListLangKeyActionDialogActivity;
import io.github.lens0021.teogeul.event.CommitComposingTextEvent;
import io.github.lens0021.teogeul.event.InputKeyEvent;
import io.github.lens0021.teogeul.event.InputTimeoutEvent;
import io.github.lens0021.teogeul.event.KeyUpEvent;
import io.github.lens0021.teogeul.event.OpenWnnEvent;

//TODO: Split up unnecessary procedures to each class
public class OpenWnnKOKR extends OpenWnn implements HangulEngineListener {

	public static final int[][] SHIFT_CONVERT = {
			{0x60, 0x7e},
			{0x31, 0x21},
			{0x32, 0x40},
			{0x33, 0x23},
			{0x34, 0x24},
			{0x35, 0x25},
			{0x36, 0x5e},
			{0x37, 0x26},
			{0x38, 0x2a},
			{0x39, 0x28},
			{0x30, 0x29},
			{0x2d, 0x5f},
			{0x3d, 0x2b},

			{0x5b, 0x7b},
			{0x5d, 0x7d},
			{0x5c, 0x7c},

			{0x3b, 0x3a},
			{0x27, 0x22},

			{0x2c, 0x3c},
			{0x2e, 0x3e},
			{0x2f, 0x3f},
	};

	// QWERTY to DVORAK hardware keyboard layout mapping
	// Maps QWERTY KeyEvent.KEYCODE to DVORAK KeyEvent.KEYCODE
	private static final Map<Integer, Integer> QWERTY_TO_DVORAK = new HashMap<>();
	static {
		// Top row (QWERTY: q w e r t y u i o p [ ])
		// DVORAK:  ' , . p y f g c r l / =
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_Q, KeyEvent.KEYCODE_APOSTROPHE);  // q → '
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_W, KeyEvent.KEYCODE_COMMA);       // w → ,
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_E, KeyEvent.KEYCODE_PERIOD);      // e → .
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_P);           // r → p
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_T, KeyEvent.KEYCODE_Y);           // t → y
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_Y, KeyEvent.KEYCODE_F);           // y → f
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_U, KeyEvent.KEYCODE_G);           // u → g
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_I, KeyEvent.KEYCODE_C);           // i → c
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_R);           // o → r
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_P, KeyEvent.KEYCODE_L);           // p → l
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_LEFT_BRACKET, KeyEvent.KEYCODE_SLASH);       // [ → /
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_RIGHT_BRACKET, KeyEvent.KEYCODE_EQUALS);     // ] → =

		// Middle row (QWERTY: a s d f g h j k l ; ')
		// DVORAK:   a o e u i d h t n s -
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_A, KeyEvent.KEYCODE_A);           // a → a (same)
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_O);           // s → o
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_D, KeyEvent.KEYCODE_E);           // d → e
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_F, KeyEvent.KEYCODE_U);           // f → u
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_G, KeyEvent.KEYCODE_I);           // g → i
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_H, KeyEvent.KEYCODE_D);           // h → d
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_J, KeyEvent.KEYCODE_H);           // j → h
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_K, KeyEvent.KEYCODE_T);           // k → t
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_L, KeyEvent.KEYCODE_N);           // l → n
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_SEMICOLON, KeyEvent.KEYCODE_S);   // ; → s
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_APOSTROPHE, KeyEvent.KEYCODE_MINUS);  // ' → -

		// Bottom row (QWERTY: z x c v b n m , . /)
		// DVORAK:   ; q j k x b m w v z
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_Z, KeyEvent.KEYCODE_SEMICOLON);   // z → ;
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_X, KeyEvent.KEYCODE_Q);           // x → q
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_C, KeyEvent.KEYCODE_J);           // c → j
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_V, KeyEvent.KEYCODE_K);           // v → k
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_B, KeyEvent.KEYCODE_X);           // b → x
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_N, KeyEvent.KEYCODE_B);           // n → b
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_M);           // m → m (same)
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_COMMA, KeyEvent.KEYCODE_W);       // , → w
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_PERIOD, KeyEvent.KEYCODE_V);      // . → v
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_SLASH, KeyEvent.KEYCODE_Z);       // / → z

		// Reverse mappings (for inverse conversion)
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_MINUS, KeyEvent.KEYCODE_LEFT_BRACKET);   // - → [
		QWERTY_TO_DVORAK.put(KeyEvent.KEYCODE_EQUALS, KeyEvent.KEYCODE_RIGHT_BRACKET); // = → ]
	}

	public static final String LANGKEY_LIST_ACTIONS = "list_actions";
	public static final String LANGKEY_SWITCH_KOR_ENG = "switch_kor_eng";
	public static final String LANGKEY_SWITCH_NEXT_METHOD = "switch_next_method";
	public static final String LANGKEY_LIST_METHODS = "list_methods";
	public static final String LANGKEY_OPEN_SETTINGS = "open_settings";

	HangulEngine mHangulEngine;
	HangulEngine mQwertyEngine;

	int mHardShift;
	int mHardAlt;
	boolean mCapsLock;
	boolean mShiftOnCapsLock;

	boolean mShiftPressing;
	boolean mAltPressing;

	EngineMode mCurrentEngineMode;
	int mCurrentLanguage = EngineMode.LANG_KO;

	private static final int[] mShiftKeyToggle = {0, MetaKeyKeyListener.META_SHIFT_ON, MetaKeyKeyListener.META_CAP_LOCKED};

	private static final int[] mAltKeyToggle = {0, MetaKeyKeyListener.META_ALT_ON, MetaKeyKeyListener.META_ALT_LOCKED};

	boolean mDirectInputMode;
	boolean mEnableTimeout;

	boolean mMoachigi;
	boolean mHardwareMoachigi;
	boolean mFullMoachigi = true;
	int mMoachigiDelay;

	boolean mStandardJamo;
	String mLangKeyAction;

	// Hardware keyboard layout setting
	boolean mEnableDvorakLayout;

	boolean mAltDirect;

	boolean mSelectionMode;
	int mSelectionStart, mSelectionEnd;

	boolean mInput;

	Handler mTimeOutHandler;

	KeystrokePreference.KeyStroke mHardLangKey;

	private static OpenWnnKOKR mSelf;
	public static OpenWnnKOKR getInstance() {
		return mSelf;
	}

	public OpenWnnKOKR() {
		super();
		mSelf = this;

		mQwertyEngine = new HangulEngine();
		mQwertyEngine.setListener(this);
		mHangulEngine = mQwertyEngine;

		mAutoHideMode = false;
	}

	public OpenWnnKOKR(Context context) {
		this();
		attachBaseContext(context);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		EventBus.getDefault().register(this);
	}

	@Override
	public View onCreateInputView() {
		return super.onCreateInputView();
	}

	@Override
	public void onStartInputView(EditorInfo attribute, boolean restarting) {
		resetCharComposition();
		super.onStartInputView(attribute, restarting);
		applyPreferences();
	}

	@Override
	public void onStartInput(EditorInfo attribute, boolean restarting) {
		super.onStartInput(attribute, restarting);
		applyPreferences();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onFinishInput() {
		resetCharComposition();
		super.onFinishInput();
	}

	@Override
		public void onViewClicked(boolean focusChanged) {
		resetCharComposition();
		super.onViewClicked(focusChanged);
	}

	@Override
	public void onEvent(HangulEngineEvent event) {
		if(event instanceof FinishComposingEvent) {
			if(mInputConnection != null) mInputConnection.finishComposingText();
		}
		if(event instanceof SetComposingEvent) {
			SetComposingEvent composingEvent = (SetComposingEvent) event;
			mInputConnection.setComposingText(composingEvent.getComposing(), 1);
		}
	}

	@Subscribe
	public void onKeyUp(KeyUpEvent event) {
		int key = event.getKeyEvent().getKeyCode();
		if(!mShiftPressing){
			if(key == KeyEvent.KEYCODE_SHIFT_LEFT
					|| key == KeyEvent.KEYCODE_SHIFT_RIGHT){
				mHardShift = 0;
				mShiftPressing = true;
				if(mShiftOnCapsLock) {
					mHardShift = 2;
					mShiftPressing = true;
					mShiftOnCapsLock = false;
				}
				updateMetaKeyStateDisplay();
			}
		}
		if(!mAltPressing) {
			if(key == KeyEvent.KEYCODE_ALT_LEFT || key == KeyEvent.KEYCODE_ALT_RIGHT){
				mHardAlt = 0;
				mAltPressing = true;
				updateMetaKeyStateDisplay();
			}
		}
	}

	@Subscribe
	public void onInputTimeout(InputTimeoutEvent event) {
		if(mEnableTimeout) {
			resetCharComposition();
		}
	}

	@Subscribe
	public void onInputKey(InputKeyEvent event) {
		KeyEvent keyEvent = event.getKeyEvent();
		switch(keyEvent.getKeyCode()) {
		case KeyEvent.KEYCODE_ALT_LEFT:
		case KeyEvent.KEYCODE_ALT_RIGHT:
			if (keyEvent.getRepeatCount() == 0) {
				if (++mHardAlt > 2) { mHardAlt = 0; }
			}
			mAltPressing   = true;
			updateMetaKeyStateDisplay();
			return;

		case KeyEvent.KEYCODE_SHIFT_LEFT:
		case KeyEvent.KEYCODE_SHIFT_RIGHT:
			if (keyEvent.getRepeatCount() == 0) {
				if (++mHardShift > 2) { mHardShift = 0; }
			}
			mShiftPressing = true;
			if(mCapsLock) {
				mHardShift = 0;
				mShiftPressing = false;
				mShiftOnCapsLock = true;
			}
			updateMetaKeyStateDisplay();
			return;

		case KeyEvent.KEYCODE_CAPS_LOCK:
			mCapsLock = !mCapsLock;
			if(mCapsLock) {
				mHardShift = 2;
				mShiftPressing = true;
			} else {
				mHardShift = 0;
				mShiftPressing = false;
			}
			updateMetaKeyStateDisplay();
			return;

		}
		if((keyEvent.getMetaState() & KeyEvent.META_CAPS_LOCK_ON) != 0) {
			if(!mShiftOnCapsLock) {
				mCapsLock = true;
				mHardShift = 2;
				mShiftPressing = true;
				updateMetaKeyStateDisplay();
			}
		} else if(mCapsLock) {
			mCapsLock = false;
			mHardShift = 0;
			mShiftPressing = false;
			updateMetaKeyStateDisplay();
		}
		boolean ret = processKeyEvent(keyEvent);
		event.setCancelled(ret);
		shinShift();
	}

	@Subscribe
	public void onCommitComposingText(CommitComposingTextEvent event) {
		getCurrentInputConnection().finishComposingText();
	}

	@Override
	public boolean onEvent(OpenWnnEvent ev) {
		return false;
	}

	private void inputChar(char code, boolean direct) {
		int shift = mHardShift;

		if (code == 128) {
			code = (char) ((shift > 0) ? 0x2c : 0x2e);
			shift = 0;
			direct = true;
		}

		char originalCode = code;
		for (int[] item : SHIFT_CONVERT) {
			if(code == item[1]) {
				code = (char) item[0];
				shift = 1;
			}
		}

		if (mDirectInputMode) {
			code = originalCode;
			resetCharComposition();
			directInput(code, shift > 0);
			return;
		} else if (direct) {
			resetCharComposition();
			mInputConnection.commitText(new String(new char[] {originalCode}), 1);
			resetCharComposition();
			return;
		}

		int inputCode = mHangulEngine.inputCode(Character.toLowerCase(code), shift);
		if(inputCode != -1) {
			if(mHangulEngine.inputJamo(inputCode) == 0) {
				mInputConnection.commitText(new String(new char[] {(char) inputCode}), 1);
				resetCharComposition();
			}
		} else {
			resetCharComposition();
			if (shift > 0) {
				code = Character.toUpperCase(originalCode);
				for (int[] item : SHIFT_CONVERT) {
					if (code == item[0]) {
						code = (char) item[1];
					}
				}
			}
			mInputConnection.commitText(new String(new char[]{code}), 1);
			resetCharComposition();
		}
	}

	private void directInput(char code, boolean shift) {
		if (shift) {
			code = Character.toUpperCase(code);
			for(int[] item : SHIFT_CONVERT) {
				if(code == item[0]) {
					code = (char) item[1];
					break;
				}
			}
		}
		mInputConnection.commitText(String.valueOf(code), 1);
	}

	public void onLangKey(String action) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		IBinder token = Objects.requireNonNull(getWindow().getWindow()).getAttributes().token;

		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = pref.edit();

		switch(action) {
		case LANGKEY_LIST_ACTIONS:
			Intent intent = new Intent(this, ListLangKeyActionDialogActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			break;

		case LANGKEY_SWITCH_KOR_ENG:
			toggleLanguage();
			break;

		case LANGKEY_SWITCH_NEXT_METHOD:
			if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				assert imm != null;
				if (mInput) {
					mInput = false;
					imm.switchToLastInputMethod(token);
				} else {
					imm.switchToNextInputMethod(token, false);
				}
			}
			break;

		case LANGKEY_LIST_METHODS:
			assert imm != null;
			imm.showInputMethodPicker();
			break;

		case LANGKEY_OPEN_SETTINGS:
			intent = new Intent(this, OpenWnnControlPanelKOKR.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			break;

		}
	}

	/**
	 * Convert hardware keyboard key event from QWERTY to DVORAK layout
	 * @param ev Original KeyEvent from hardware keyboard (QWERTY layout)
	 * @return Converted KeyEvent for DVORAK layout, or null if no conversion needed
	 */
	private KeyEvent convertQwertyToDvorak(KeyEvent ev) {
		if (!mEnableDvorakLayout) {
			return null;
		}

		int originalKeyCode = ev.getKeyCode();
		Integer convertedKeyCode = QWERTY_TO_DVORAK.get(originalKeyCode);

		if (convertedKeyCode == null) {
			// No mapping found - keys like numbers, space, enter, etc.
			return null;
		}

		// Create new KeyEvent with converted key code
		return new KeyEvent(
			ev.getDownTime(),
			ev.getEventTime(),
			ev.getAction(),
			convertedKeyCode,        // Converted key code
			ev.getRepeatCount(),
			ev.getMetaState(),       // Preserve Ctrl, Shift, Alt states
			ev.getDeviceId(),
			ev.getScanCode(),
			ev.getFlags(),
			ev.getSource()
		);
	}

	@SuppressLint("NewApi")
	private boolean processKeyEvent(KeyEvent ev) {
		if(mInputConnection == null) return false;
		int key = ev.getKeyCode();

		if (ev.isShiftPressed()) {
			switch (key) {
			case KeyEvent.KEYCODE_DPAD_UP:
			case KeyEvent.KEYCODE_DPAD_DOWN:
			case KeyEvent.KEYCODE_DPAD_LEFT:
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				if (!mSelectionMode) {
					mSelectionEnd = mInputConnection.getTextBeforeCursor(Integer.MAX_VALUE, 0).length();
					mSelectionStart = mSelectionEnd;
					mSelectionMode = true;
				} else {
					if (key == KeyEvent.KEYCODE_DPAD_LEFT) mSelectionEnd--;
					if (key == KeyEvent.KEYCODE_DPAD_RIGHT) mSelectionEnd++;
					if (key == KeyEvent.KEYCODE_DPAD_UP) {
						int i = 1;
						CharSequence text = "";
						boolean end;
						while(!(end = mInputConnection.getTextBeforeCursor(i, 0).equals(text)) && (text = mInputConnection.getTextBeforeCursor(i, 0)).charAt(0) != '\n') i++;
						if(end) mSelectionEnd -= mInputConnection.getTextBeforeCursor(Integer.MAX_VALUE, 0).length();
						else mSelectionEnd -= i;
					}
					if (key == KeyEvent.KEYCODE_DPAD_DOWN) {
						int i = 1;
						CharSequence text = "";
						boolean end;
						while(!(end = mInputConnection.getTextAfterCursor(i, 0).equals(text)) && (text = mInputConnection.getTextAfterCursor(i, 0)).charAt(text.length()-1) != '\n') i++;
						if(end) mSelectionEnd += mInputConnection.getTextAfterCursor(Character.MAX_VALUE, 0).length();
						else mSelectionEnd += i;
					}
					int start = mSelectionStart, end = mSelectionEnd;
					if (mSelectionStart > mSelectionEnd) {
							start = mSelectionEnd;
							end = mSelectionStart;
						}
					mInputConnection.setSelection(start, end);
					mHardShift = 0;
					updateMetaKeyStateDisplay();
					updateMetaKeyStateDisplay();
				}
				return true;

			default:
				mSelectionMode = false;
				break;
			}
		} else {
			mSelectionMode = false;
		}

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (ev.isCtrlPressed()) {
				// Convert hardware keyboard layout if DVORAK is enabled
				KeyEvent convertedEvent = convertQwertyToDvorak(ev);
				if (convertedEvent != null && mInputConnection != null) {
					// Send converted key event to the app
					mInputConnection.sendKeyEvent(convertedEvent);
					return true;  // Handled by IME
				}
				return false;  // Pass through for QWERTY or unmapped keys
			}
		}

		if (key >= KeyEvent.KEYCODE_NUMPAD_0 && key <= KeyEvent.KEYCODE_NUMPAD_RIGHT_PAREN) {
			resetCharComposition();
			return false;
		}

		if(mHardLangKey != null && key == mHardLangKey.getKeyCode()) {
			if((mHardShift == 1) == mHardLangKey.isShift()
					&& ((mHardAlt == 1) == mHardLangKey.isAlt())
					&& ev.isCtrlPressed() == mHardLangKey.isControl()
					&& ev.isMetaPressed() == mHardLangKey.isWin()) {

				resetCharComposition();
				toggleLanguage();
				mHardShift = 0;
				mShiftPressing = false;
				mHardAlt = 0;
				mAltPressing = false;
				updateMetaKeyStateDisplay();
				return true;
			}
		}

		if (ev.isPrintingKey()) {
			// Convert hardware keyboard layout if DVORAK is enabled
			KeyEvent processedEvent = ev;
			KeyEvent convertedEvent = convertQwertyToDvorak(ev);
			if (convertedEvent != null) {
				processedEvent = convertedEvent;
			}

			int code = processedEvent.getUnicodeChar(mShiftKeyToggle[mHardShift] | mAltKeyToggle[mHardAlt]);
			this.inputChar((char) code, mHardAlt != 0 && mAltDirect);
			mInput = true;

			if (mHardShift == 1) {
				mShiftPressing = false;
			}
			if (mHardAlt == 1) {
				mAltPressing = false;
			}
			if (!ev.isAltPressed()) {
				if (mHardAlt == 1) {
					mHardAlt = 0;
				}
			}
			if (!ev.isShiftPressed()) {
				if (mHardShift == 1) {
					mHardShift = 0;
				}
			}
			if (!ev.isShiftPressed() && !ev.isShiftPressed()) {
				updateMetaKeyStateDisplay();
			}

			return true;

		} else if (key == KeyEvent.KEYCODE_SPACE) {
			// 한글 조합을 종료한다
			resetCharComposition();
			mInputConnection.commitText(" ", 1);
			return true;
		} else if (key == KeyEvent.KEYCODE_DEL) {
			if(!mHangulEngine.backspace()) {
				resetCharComposition();
				mInputConnection.deleteSurroundingText(1, 0);
			}
			if (mHangulEngine.getComposing().equals(""))
				resetCharComposition();
			return true;
		} else if(key == KeyEvent.KEYCODE_ENTER) {
			resetCharComposition();
			mHardShift = 0;
			mHardAlt = 0;
			updateMetaKeyStateDisplay();
			EditorInfo editorInfo = getCurrentInputEditorInfo();
			switch(editorInfo.imeOptions & EditorInfo.IME_MASK_ACTION) {
			case EditorInfo.IME_ACTION_SEARCH:
			case EditorInfo.IME_ACTION_GO:
				sendDefaultEditorAction(true);
				return true;

			default:
				return false;
			}
		} else {
			resetCharComposition();
		}

		return false;
	}

	private void shinShift() {
		updateMetaKeyStateDisplay();
	}

	public void updateMetaKeyStateDisplay() {
	}

	private void applyPreferences() {
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		mHardwareMoachigi = pref.getBoolean("hardware_use_moachigi", mHardwareMoachigi);
		mFullMoachigi = pref.getBoolean("hardware_full_moachigi", mFullMoachigi);
		mMoachigiDelay = pref.getInt("hardware_full_moachigi_delay", 100);
		mStandardJamo = pref.getBoolean("system_use_standard_jamo", mStandardJamo);
		mLangKeyAction = pref.getString("system_action_on_lang_key_press", LANGKEY_SWITCH_KOR_ENG);
		mHardLangKey = KeystrokePreference.parseKeyStroke(pref.getString("system_hardware_lang_key_stroke", "---s62"));
		mAltDirect = pref.getBoolean("hardware_alt_direct", true);
		mEnableDvorakLayout = pref.getBoolean("hardware_enable_dvorak", true);

		String modeKey;
		if (mCurrentLanguage == EngineMode.LANG_EN) {
			modeKey = pref.getString("hardware_alphabet_layout", "keyboard_alphabet_qwerty");
		} else {
			modeKey = pref.getString("hardware_hangul_layout", "keyboard_sebul_391");
		}
		applyEngineMode(EngineMode.get(modeKey));
	}

	private void applyEngineMode(EngineMode mode) {
		mCurrentEngineMode = mode;
		if(mode == EngineMode.DIRECT) {
			mDirectInputMode = true;
			mEnableTimeout = false;
			mFullMoachigi = false;
			mHangulEngine = mQwertyEngine;
			mHangulEngine.setJamoTable(null);
			mHangulEngine.setCombinationTable(null);
			return;
		}

		EngineMode.Properties prop = mode.properties;
		mDirectInputMode = prop.direct;
		mEnableTimeout = prop.timeout;
		mFullMoachigi = prop.fullMoachigi;
		mHangulEngine = mQwertyEngine;
		if(mode.jamoset != null) mHangulEngine.setJamoSet(mode.jamoset);
		else mHangulEngine.setJamoTable(mode.layout);
		mHangulEngine.setCombinationTable(mode.combination);
		mHangulEngine.setFirstMidEnd(mStandardJamo);
		mHangulEngine.setMoachigi(mHardwareMoachigi);
		mHangulEngine.setFullMoachigi(mFullMoachigi);
		if(mFullMoachigi) mEnableTimeout = true;
	}

	private void resetCharComposition() {
		mHangulEngine.resetComposition();
	}

	private void toggleLanguage() {
		if (mCurrentLanguage == EngineMode.LANG_EN) {
			mCurrentLanguage = EngineMode.LANG_KO;
		} else {
			mCurrentLanguage = EngineMode.LANG_EN;
		}
		applyPreferences();
	}

	public void resetHardShift(boolean force) {
		if(mHardShift == 2 && !force) return;
		mHardShift = 0;
		mShiftPressing = false;
	}

	@Override
	public void hideWindow() {
		super.hideWindow();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(mTimeOutHandler == null) {
			mTimeOutHandler = new Handler();
			mTimeOutHandler.postDelayed(() -> {
                EventBus.getDefault().post(new InputTimeoutEvent());
                mTimeOutHandler = null;
            }, mMoachigiDelay);
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onEvaluateFullscreenMode() {
		return false;
	}

	@Override
	public boolean onEvaluateInputViewShown() {
		super.onEvaluateInputViewShown();
		return true;
	}

	@Override
	public void requestHideSelf(int flag) {
		super.requestHideSelf(flag);
		hideWindow();
	}

	public HangulEngine getHangulEngine() {
		return mHangulEngine;
	}

	public int[][] getAltSymbols() {
		return mAltLayout;
	}
}
