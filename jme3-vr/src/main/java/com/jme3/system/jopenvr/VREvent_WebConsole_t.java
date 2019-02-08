package com.jme3.system.jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:1405</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VREvent_WebConsole_t extends Structure {
	/** C type : WebConsoleHandle_t */
	public long webConsoleHandle;
	public VREvent_WebConsole_t() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("webConsoleHandle");
	}
	/** @param webConsoleHandle C type : WebConsoleHandle_t */
	public VREvent_WebConsole_t(long webConsoleHandle) {
		super();
		this.webConsoleHandle = webConsoleHandle;
	}
	public VREvent_WebConsole_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VREvent_WebConsole_t implements Structure.ByReference {
		
	};
	public static class ByValue extends VREvent_WebConsole_t implements Structure.ByValue {
		
	};
}
