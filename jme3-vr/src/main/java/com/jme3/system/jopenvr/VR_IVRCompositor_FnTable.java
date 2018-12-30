package com.jme3.system.jopenvr;
import com.jme3.system.jopenvr.JOpenVRLibrary.VkPhysicalDevice_T;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h:2045</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VR_IVRCompositor_FnTable extends Structure {
	/** C type : SetTrackingSpace_callback* */
	public VR_IVRCompositor_FnTable.SetTrackingSpace_callback SetTrackingSpace;
	/** C type : GetTrackingSpace_callback* */
	public VR_IVRCompositor_FnTable.GetTrackingSpace_callback GetTrackingSpace;
	/** C type : WaitGetPoses_callback* */
	public VR_IVRCompositor_FnTable.WaitGetPoses_callback WaitGetPoses;
	/** C type : GetLastPoses_callback* */
	public VR_IVRCompositor_FnTable.GetLastPoses_callback GetLastPoses;
	/** C type : GetLastPoseForTrackedDeviceIndex_callback* */
	public VR_IVRCompositor_FnTable.GetLastPoseForTrackedDeviceIndex_callback GetLastPoseForTrackedDeviceIndex;
	/** C type : Submit_callback* */
	public VR_IVRCompositor_FnTable.Submit_callback Submit;
	/** C type : ClearLastSubmittedFrame_callback* */
	public VR_IVRCompositor_FnTable.ClearLastSubmittedFrame_callback ClearLastSubmittedFrame;
	/** C type : PostPresentHandoff_callback* */
	public VR_IVRCompositor_FnTable.PostPresentHandoff_callback PostPresentHandoff;
	/** C type : GetFrameTiming_callback* */
	public VR_IVRCompositor_FnTable.GetFrameTiming_callback GetFrameTiming;
	/** C type : GetFrameTimings_callback* */
	public VR_IVRCompositor_FnTable.GetFrameTimings_callback GetFrameTimings;
	/** C type : GetFrameTimeRemaining_callback* */
	public VR_IVRCompositor_FnTable.GetFrameTimeRemaining_callback GetFrameTimeRemaining;
	/** C type : GetCumulativeStats_callback* */
	public VR_IVRCompositor_FnTable.GetCumulativeStats_callback GetCumulativeStats;
	/** C type : FadeToColor_callback* */
	public VR_IVRCompositor_FnTable.FadeToColor_callback FadeToColor;
	/** C type : GetCurrentFadeColor_callback* */
	public VR_IVRCompositor_FnTable.GetCurrentFadeColor_callback GetCurrentFadeColor;
	/** C type : FadeGrid_callback* */
	public VR_IVRCompositor_FnTable.FadeGrid_callback FadeGrid;
	/** C type : GetCurrentGridAlpha_callback* */
	public VR_IVRCompositor_FnTable.GetCurrentGridAlpha_callback GetCurrentGridAlpha;
	/** C type : SetSkyboxOverride_callback* */
	public VR_IVRCompositor_FnTable.SetSkyboxOverride_callback SetSkyboxOverride;
	/** C type : ClearSkyboxOverride_callback* */
	public VR_IVRCompositor_FnTable.ClearSkyboxOverride_callback ClearSkyboxOverride;
	/** C type : CompositorBringToFront_callback* */
	public VR_IVRCompositor_FnTable.CompositorBringToFront_callback CompositorBringToFront;
	/** C type : CompositorGoToBack_callback* */
	public VR_IVRCompositor_FnTable.CompositorGoToBack_callback CompositorGoToBack;
	/** C type : CompositorQuit_callback* */
	public VR_IVRCompositor_FnTable.CompositorQuit_callback CompositorQuit;
	/** C type : IsFullscreen_callback* */
	public VR_IVRCompositor_FnTable.IsFullscreen_callback IsFullscreen;
	/** C type : GetCurrentSceneFocusProcess_callback* */
	public VR_IVRCompositor_FnTable.GetCurrentSceneFocusProcess_callback GetCurrentSceneFocusProcess;
	/** C type : GetLastFrameRenderer_callback* */
	public VR_IVRCompositor_FnTable.GetLastFrameRenderer_callback GetLastFrameRenderer;
	/** C type : CanRenderScene_callback* */
	public VR_IVRCompositor_FnTable.CanRenderScene_callback CanRenderScene;
	/** C type : ShowMirrorWindow_callback* */
	public VR_IVRCompositor_FnTable.ShowMirrorWindow_callback ShowMirrorWindow;
	/** C type : HideMirrorWindow_callback* */
	public VR_IVRCompositor_FnTable.HideMirrorWindow_callback HideMirrorWindow;
	/** C type : IsMirrorWindowVisible_callback* */
	public VR_IVRCompositor_FnTable.IsMirrorWindowVisible_callback IsMirrorWindowVisible;
	/** C type : CompositorDumpImages_callback* */
	public VR_IVRCompositor_FnTable.CompositorDumpImages_callback CompositorDumpImages;
	/** C type : ShouldAppRenderWithLowResources_callback* */
	public VR_IVRCompositor_FnTable.ShouldAppRenderWithLowResources_callback ShouldAppRenderWithLowResources;
	/** C type : ForceInterleavedReprojectionOn_callback* */
	public VR_IVRCompositor_FnTable.ForceInterleavedReprojectionOn_callback ForceInterleavedReprojectionOn;
	/** C type : ForceReconnectProcess_callback* */
	public VR_IVRCompositor_FnTable.ForceReconnectProcess_callback ForceReconnectProcess;
	/** C type : SuspendRendering_callback* */
	public VR_IVRCompositor_FnTable.SuspendRendering_callback SuspendRendering;
	/** C type : GetMirrorTextureD3D11_callback* */
	public VR_IVRCompositor_FnTable.GetMirrorTextureD3D11_callback GetMirrorTextureD3D11;
	/** C type : ReleaseMirrorTextureD3D11_callback* */
	public VR_IVRCompositor_FnTable.ReleaseMirrorTextureD3D11_callback ReleaseMirrorTextureD3D11;
	/** C type : GetMirrorTextureGL_callback* */
	public VR_IVRCompositor_FnTable.GetMirrorTextureGL_callback GetMirrorTextureGL;
	/** C type : ReleaseSharedGLTexture_callback* */
	public VR_IVRCompositor_FnTable.ReleaseSharedGLTexture_callback ReleaseSharedGLTexture;
	/** C type : LockGLSharedTextureForAccess_callback* */
	public VR_IVRCompositor_FnTable.LockGLSharedTextureForAccess_callback LockGLSharedTextureForAccess;
	/** C type : UnlockGLSharedTextureForAccess_callback* */
	public VR_IVRCompositor_FnTable.UnlockGLSharedTextureForAccess_callback UnlockGLSharedTextureForAccess;
	/** C type : GetVulkanInstanceExtensionsRequired_callback* */
	public VR_IVRCompositor_FnTable.GetVulkanInstanceExtensionsRequired_callback GetVulkanInstanceExtensionsRequired;
	/** C type : GetVulkanDeviceExtensionsRequired_callback* */
	public VR_IVRCompositor_FnTable.GetVulkanDeviceExtensionsRequired_callback GetVulkanDeviceExtensionsRequired;
	/** C type : SetExplicitTimingMode_callback* */
	public VR_IVRCompositor_FnTable.SetExplicitTimingMode_callback SetExplicitTimingMode;
	/** C type : SubmitExplicitTimingData_callback* */
	public VR_IVRCompositor_FnTable.SubmitExplicitTimingData_callback SubmitExplicitTimingData;
	/** <i>native declaration : headers\openvr_capi.h:2002</i> */
	public interface SetTrackingSpace_callback extends Callback {
		void apply(int eOrigin);
	};
	/** <i>native declaration : headers\openvr_capi.h:2003</i> */
	public interface GetTrackingSpace_callback extends Callback {
		int apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2004</i> */
	public interface WaitGetPoses_callback extends Callback {
		int apply(TrackedDevicePose_t pRenderPoseArray, int unRenderPoseArrayCount, TrackedDevicePose_t pGamePoseArray, int unGamePoseArrayCount);
	};
	/** <i>native declaration : headers\openvr_capi.h:2005</i> */
	public interface GetLastPoses_callback extends Callback {
		int apply(TrackedDevicePose_t pRenderPoseArray, int unRenderPoseArrayCount, TrackedDevicePose_t pGamePoseArray, int unGamePoseArrayCount);
	};
	/** <i>native declaration : headers\openvr_capi.h:2006</i> */
	public interface GetLastPoseForTrackedDeviceIndex_callback extends Callback {
		int apply(int unDeviceIndex, TrackedDevicePose_t pOutputPose, TrackedDevicePose_t pOutputGamePose);
	};
	/** <i>native declaration : headers\openvr_capi.h:2007</i> */
	public interface Submit_callback extends Callback {
		int apply(int eEye, Texture_t pTexture, VRTextureBounds_t pBounds, int nSubmitFlags);
	};
	/** <i>native declaration : headers\openvr_capi.h:2008</i> */
	public interface ClearLastSubmittedFrame_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2009</i> */
	public interface PostPresentHandoff_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2010</i> */
	public interface GetFrameTiming_callback extends Callback {
		byte apply(Compositor_FrameTiming pTiming, int unFramesAgo);
	};
	/** <i>native declaration : headers\openvr_capi.h:2011</i> */
	public interface GetFrameTimings_callback extends Callback {
		int apply(Compositor_FrameTiming pTiming, int nFrames);
	};
	/** <i>native declaration : headers\openvr_capi.h:2012</i> */
	public interface GetFrameTimeRemaining_callback extends Callback {
		float apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2013</i> */
	public interface GetCumulativeStats_callback extends Callback {
		void apply(Compositor_CumulativeStats pStats, int nStatsSizeInBytes);
	};
	/** <i>native declaration : headers\openvr_capi.h:2014</i> */
	public interface FadeToColor_callback extends Callback {
		void apply(float fSeconds, float fRed, float fGreen, float fBlue, float fAlpha, byte bBackground);
	};
	/** <i>native declaration : headers\openvr_capi.h:2015</i> */
	public interface GetCurrentFadeColor_callback extends Callback {
		com.jme3.system.jopenvr.HmdColor_t.ByValue apply(byte bBackground);
	};
	/** <i>native declaration : headers\openvr_capi.h:2016</i> */
	public interface FadeGrid_callback extends Callback {
		void apply(float fSeconds, byte bFadeIn);
	};
	/** <i>native declaration : headers\openvr_capi.h:2017</i> */
	public interface GetCurrentGridAlpha_callback extends Callback {
		float apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2018</i> */
	public interface SetSkyboxOverride_callback extends Callback {
		int apply(Texture_t pTextures, int unTextureCount);
	};
	/** <i>native declaration : headers\openvr_capi.h:2019</i> */
	public interface ClearSkyboxOverride_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2020</i> */
	public interface CompositorBringToFront_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2021</i> */
	public interface CompositorGoToBack_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2022</i> */
	public interface CompositorQuit_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2023</i> */
	public interface IsFullscreen_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2024</i> */
	public interface GetCurrentSceneFocusProcess_callback extends Callback {
		int apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2025</i> */
	public interface GetLastFrameRenderer_callback extends Callback {
		int apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2026</i> */
	public interface CanRenderScene_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2027</i> */
	public interface ShowMirrorWindow_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2028</i> */
	public interface HideMirrorWindow_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2029</i> */
	public interface IsMirrorWindowVisible_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2030</i> */
	public interface CompositorDumpImages_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2031</i> */
	public interface ShouldAppRenderWithLowResources_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2032</i> */
	public interface ForceInterleavedReprojectionOn_callback extends Callback {
		void apply(byte bOverride);
	};
	/** <i>native declaration : headers\openvr_capi.h:2033</i> */
	public interface ForceReconnectProcess_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:2034</i> */
	public interface SuspendRendering_callback extends Callback {
		void apply(byte bSuspend);
	};
	/** <i>native declaration : headers\openvr_capi.h:2035</i> */
	public interface GetMirrorTextureD3D11_callback extends Callback {
		int apply(int eEye, Pointer pD3D11DeviceOrResource, PointerByReference ppD3D11ShaderResourceView);
	};
	/** <i>native declaration : headers\openvr_capi.h:2036</i> */
	public interface ReleaseMirrorTextureD3D11_callback extends Callback {
		void apply(Pointer pD3D11ShaderResourceView);
	};
	/** <i>native declaration : headers\openvr_capi.h:2037</i> */
	public interface GetMirrorTextureGL_callback extends Callback {
		int apply(int eEye, IntByReference pglTextureId, PointerByReference pglSharedTextureHandle);
	};
	/** <i>native declaration : headers\openvr_capi.h:2038</i> */
	public interface ReleaseSharedGLTexture_callback extends Callback {
		byte apply(int glTextureId, Pointer glSharedTextureHandle);
	};
	/** <i>native declaration : headers\openvr_capi.h:2039</i> */
	public interface LockGLSharedTextureForAccess_callback extends Callback {
		void apply(Pointer glSharedTextureHandle);
	};
	/** <i>native declaration : headers\openvr_capi.h:2040</i> */
	public interface UnlockGLSharedTextureForAccess_callback extends Callback {
		void apply(Pointer glSharedTextureHandle);
	};
	/** <i>native declaration : headers\openvr_capi.h:2041</i> */
	public interface GetVulkanInstanceExtensionsRequired_callback extends Callback {
		int apply(Pointer pchValue, int unBufferSize);
	};
	/** <i>native declaration : headers\openvr_capi.h:2042</i> */
	public interface GetVulkanDeviceExtensionsRequired_callback extends Callback {
		int apply(VkPhysicalDevice_T pPhysicalDevice, Pointer pchValue, int unBufferSize);
	};
	/** <i>native declaration : headers\openvr_capi.h:2043</i> */
	public interface SetExplicitTimingMode_callback extends Callback {
		void apply(int eTimingMode);
	};
	/** <i>native declaration : headers\openvr_capi.h:2044</i> */
	public interface SubmitExplicitTimingData_callback extends Callback {
		int apply();
	};
	public VR_IVRCompositor_FnTable() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("SetTrackingSpace", "GetTrackingSpace", "WaitGetPoses", "GetLastPoses", "GetLastPoseForTrackedDeviceIndex", "Submit", "ClearLastSubmittedFrame", "PostPresentHandoff", "GetFrameTiming", "GetFrameTimings", "GetFrameTimeRemaining", "GetCumulativeStats", "FadeToColor", "GetCurrentFadeColor", "FadeGrid", "GetCurrentGridAlpha", "SetSkyboxOverride", "ClearSkyboxOverride", "CompositorBringToFront", "CompositorGoToBack", "CompositorQuit", "IsFullscreen", "GetCurrentSceneFocusProcess", "GetLastFrameRenderer", "CanRenderScene", "ShowMirrorWindow", "HideMirrorWindow", "IsMirrorWindowVisible", "CompositorDumpImages", "ShouldAppRenderWithLowResources", "ForceInterleavedReprojectionOn", "ForceReconnectProcess", "SuspendRendering", "GetMirrorTextureD3D11", "ReleaseMirrorTextureD3D11", "GetMirrorTextureGL", "ReleaseSharedGLTexture", "LockGLSharedTextureForAccess", "UnlockGLSharedTextureForAccess", "GetVulkanInstanceExtensionsRequired", "GetVulkanDeviceExtensionsRequired", "SetExplicitTimingMode", "SubmitExplicitTimingData");
	}
	public VR_IVRCompositor_FnTable(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VR_IVRCompositor_FnTable implements Structure.ByReference {
		
	};
	public static class ByValue extends VR_IVRCompositor_FnTable implements Structure.ByValue {
		
	};
}
