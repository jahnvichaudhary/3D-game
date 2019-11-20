package com.jme3.system.osvr.osvrtimevalue;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
/**
 * JNA Wrapper for library <b>osvrTimeValue</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class OsvrTimeValueLibrary implements Library {
	public static final String JNA_LIBRARY_NAME = "osvrClientKit";
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(OsvrTimeValueLibrary.JNA_LIBRARY_NAME);
	static {
		Native.register(OsvrTimeValueLibrary.class, OsvrTimeValueLibrary.JNA_NATIVE_LIB);
	}
	public static final int OSVR_TRUE = (int)(1);
	public static final int OSVR_FALSE = (int)(0);
	/**
	 * Gets the current time in the TimeValue. Parallel to gettimeofday.
	 * Original signature : <code>void osvrTimeValueGetNow(OSVR_TimeValue*)</code>
	 */
	public static native void osvrTimeValueGetNow(OSVR_TimeValue dest);
	/**
	 * Converts from a TimeValue struct to your system's struct timeval.
	 * @param dest Pointer to an empty struct timeval for your platform.<br>
	 * @param src A pointer to an OSVR_TimeValue you'd like to convert from.<br>
	 * If either parameter is NULL, the function will return without doing<br>
	 * anything.<br>
	 * Original signature : <code>void osvrTimeValueToStructTimeval(timeval*, const OSVR_TimeValue*)</code>
	 */
	public static native void osvrTimeValueToStructTimeval(OsvrTimeValueLibrary.timeval dest, OSVR_TimeValue src);
	/**
	 * Converts from a TimeValue struct to your system's struct timeval.
	 * @param dest An OSVR_TimeValue destination pointer.<br>
	 * @param src Pointer to a struct timeval you'd like to convert from.<br>
	 * The result is normalized.<br>
	 * If either parameter is NULL, the function will return without doing<br>
	 * anything.<br>
	 * Original signature : <code>void osvrStructTimevalToTimeValue(OSVR_TimeValue*, timeval*)</code>
	 */
	public static native void osvrStructTimevalToTimeValue(OSVR_TimeValue dest, OsvrTimeValueLibrary.timeval src);
	/**
	 * "Normalizes" a time value so that the absolute number of microseconds
	 * is less than 1,000,000, and that the sign of both components is the same.<br>
	 * @param tv Address of a struct TimeValue to normalize in place.<br>
	 * If the given pointer is NULL, this function returns without doing anything.<br>
	 * Original signature : <code>void osvrTimeValueNormalize(OSVR_TimeValue*)</code>
	 */
	public static native void osvrTimeValueNormalize(OSVR_TimeValue tv);
	/**
	 * Sums two time values, replacing the first with the result.
	 * @param tvA Destination and first source.<br>
	 * @param tvB second source<br>
	 * If a given pointer is NULL, this function returns without doing anything.<br>
	 * Both parameters are expected to be in normalized form.<br>
	 * Original signature : <code>void osvrTimeValueSum(OSVR_TimeValue*, const OSVR_TimeValue*)</code>
	 */
	public static native void osvrTimeValueSum(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * Computes the difference between two time values, replacing the first
	 * with the result.<br>
	 * Effectively, `*tvA = *tvA - *tvB`<br>
	 * @param tvA Destination and first source.<br>
	 * @param tvB second source<br>
	 * If a given pointer is NULL, this function returns without doing anything.<br>
	 * Both parameters are expected to be in normalized form.<br>
	 * Original signature : <code>void osvrTimeValueDifference(OSVR_TimeValue*, const OSVR_TimeValue*)</code>
	 */
	public static native void osvrTimeValueDifference(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * Compares two time values (assumed to be normalized), returning
	 * the same values as strcmp<br>
	 * @return &lt;0 if A is earlier than B, 0 if they are the same, and &gt;0 if A<br>
	 * is later than B.<br>
	 * Original signature : <code>int osvrTimeValueCmp(const OSVR_TimeValue*, const OSVR_TimeValue*)</code>
	 */
	public static native int osvrTimeValueCmp(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * Compute the difference between the two time values, returning the
	 * duration as a double-precision floating-point number of seconds.<br>
	 * Effectively, `ret = *tvA - *tvB`<br>
	 * @param tvA first source.<br>
	 * @param tvB second source<br>
	 * @return Duration of timespan in seconds (floating-point)<br>
	 * Original signature : <code>double osvrTimeValueDurationSeconds(const OSVR_TimeValue*, const OSVR_TimeValue*)</code>
	 */
	public static native double osvrTimeValueDurationSeconds(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * True if A is later than B.
	 * Original signature : <code>OSVR_CBool osvrTimeValueGreater(const OSVR_TimeValue*, const OSVR_TimeValue*)</code>
	 */
	public static native byte osvrTimeValueGreater(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * Returns true if the time value is normalized. Typically used in assertions.<br>
	 * Original signature : <code>bool osvrTimeValueIsNormalized(const OSVR_TimeValue&amp;)</code>
	 */
	public static native byte osvrTimeValueIsNormalized(OSVR_TimeValue tv);
	/**
	 * Operator &gt; overload for time values<br>
	 * Original signature : <code>bool operator&gt;(const OSVR_TimeValue&amp;, const OSVR_TimeValue&amp;)</code>
	 */
	public static native byte operatorGreater(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	/**
	 * Operator == overload for time values<br>
	 * Original signature : <code>bool operator==(const OSVR_TimeValue&amp;, const OSVR_TimeValue&amp;)</code>
	 */
	public static native byte operatorIsEqual(OSVR_TimeValue tvA, OSVR_TimeValue tvB);
	public static class timeval extends PointerType {
		public timeval(Pointer address) {
			super(address);
		}
		public timeval() {
			super();
		}
	};
}
