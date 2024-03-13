package com.jme3.system.osvr.osvrclientreporttypes;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class OSVR_Vec3 extends Structure {
	/** C type : double[3] */
	public double[] data = new double[3];
	public OSVR_Vec3() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Collections.singletonList("data");
	}
	/** @param data C type : double[3] */
	public OSVR_Vec3(double data[]) {
		super();
		if ((data.length != this.data.length)) 
			throw new IllegalArgumentException("Wrong array size !");
		this.data = data;
	}
	public OSVR_Vec3(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends OSVR_Vec3 implements Structure.ByReference {
		
	};
	public static class ByValue extends OSVR_Vec3 implements Structure.ByValue {
		
	};
}
