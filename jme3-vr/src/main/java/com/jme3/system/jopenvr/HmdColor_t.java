package com.jme3.system.jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:1221</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class HmdColor_t extends Structure {
	public float r;
	public float g;
	public float b;
	public float a;
	public HmdColor_t() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("r", "g", "b", "a");
	}
	public HmdColor_t(float r, float g, float b, float a) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	public HmdColor_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends HmdColor_t implements Structure.ByReference {
		
	};
	public static class ByValue extends HmdColor_t implements Structure.ByValue {
		
	};
}
