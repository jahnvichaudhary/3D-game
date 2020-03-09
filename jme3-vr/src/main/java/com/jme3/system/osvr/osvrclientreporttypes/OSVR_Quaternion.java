package com.jme3.system.osvr.osvrclientreporttypes;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class OSVR_Quaternion extends Structure {
	/** C type : double[4] */
	public double[] data = new double[4];
	public OSVR_Quaternion() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("data");
	}
	/** @param data C type : double[4] */
	public OSVR_Quaternion(double data[]) {
		super();
		if ((data.length != this.data.length)) 
			throw new IllegalArgumentException("Wrong array size !");
		this.data = data;
	}
	public OSVR_Quaternion(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends OSVR_Quaternion implements Structure.ByReference {
		
	};
	public static class ByValue extends OSVR_Quaternion implements Structure.ByValue {
		
	};
}
