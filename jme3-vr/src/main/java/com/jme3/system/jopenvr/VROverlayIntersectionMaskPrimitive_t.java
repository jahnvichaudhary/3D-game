package com.jme3.system.jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:1702</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VROverlayIntersectionMaskPrimitive_t extends Structure {
	/**
	 * C type : EVROverlayIntersectionMaskPrimitiveType
	 */
	public int m_nPrimitiveType;
	/** C type : VROverlayIntersectionMaskPrimitive_Data_t */
	public VROverlayIntersectionMaskPrimitive_Data_t m_Primitive;
	public VROverlayIntersectionMaskPrimitive_t() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("m_nPrimitiveType", "m_Primitive");
	}
	/**
	 * @param m_nPrimitiveType @see EVROverlayIntersectionMaskPrimitiveType<br>
	 * C type : EVROverlayIntersectionMaskPrimitiveType<br>
	 * @param m_Primitive C type : VROverlayIntersectionMaskPrimitive_Data_t
	 */
	public VROverlayIntersectionMaskPrimitive_t(int m_nPrimitiveType, VROverlayIntersectionMaskPrimitive_Data_t m_Primitive) {
		super();
		this.m_nPrimitiveType = m_nPrimitiveType;
		this.m_Primitive = m_Primitive;
	}
	public VROverlayIntersectionMaskPrimitive_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VROverlayIntersectionMaskPrimitive_t implements Structure.ByReference {
		
	};
	public static class ByValue extends VROverlayIntersectionMaskPrimitive_t implements Structure.ByValue {
		
	};
}
