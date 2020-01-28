package com.jme3.system.jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:1569</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class RenderModel_TextureMap_t extends Structure {
	public short unWidth;
	public short unHeight;
	/**
	 * const uint8_t *<br>
	 * C type : uint8_t*
	 */
	public Pointer rubTextureMapData;
	public RenderModel_TextureMap_t() {
		super();
	}
        @Override
	protected List<String> getFieldOrder() {
		return Arrays.asList("unWidth", "unHeight", "rubTextureMapData");
	}
	/**
	 * @param rubTextureMapData const uint8_t *<br>
	 * C type : uint8_t*
	 */
	public RenderModel_TextureMap_t(short unWidth, short unHeight, Pointer rubTextureMapData) {
		super();
		this.unWidth = unWidth;
		this.unHeight = unHeight;
		this.rubTextureMapData = rubTextureMapData;
	}
	public RenderModel_TextureMap_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends RenderModel_TextureMap_t implements Structure.ByReference {
		
	};
	public static class ByValue extends RenderModel_TextureMap_t implements Structure.ByValue {
		
	};
}
