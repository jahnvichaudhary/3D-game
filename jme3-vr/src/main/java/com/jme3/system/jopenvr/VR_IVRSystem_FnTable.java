package com.jme3.system.jopenvr;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

import java.util.Arrays;
import java.util.List;
/**
 * OpenVR Function Pointer Tables<br>
 * <i>native declaration : headers\openvr_capi.h:1416</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VR_IVRSystem_FnTable extends Structure {
	
	/** C type : GetRecommendedRenderTargetSize_callback* */
	public VR_IVRSystem_FnTable.GetRecommendedRenderTargetSize_callback GetRecommendedRenderTargetSize;
	/** C type : GetProjectionMatrix_callback* */
	public VR_IVRSystem_FnTable.GetProjectionMatrix_callback GetProjectionMatrix;
	/** C type : GetProjectionRaw_callback* */
	public VR_IVRSystem_FnTable.GetProjectionRaw_callback GetProjectionRaw;
	/** C type : ComputeDistortion_callback* */
	public VR_IVRSystem_FnTable.ComputeDistortion_callback ComputeDistortion;
	/** C type : GetEyeToHeadTransform_callback* */
	public VR_IVRSystem_FnTable.GetEyeToHeadTransform_callback GetEyeToHeadTransform;
	/** C type : GetTimeSinceLastVsync_callback* */
	public VR_IVRSystem_FnTable.GetTimeSinceLastVsync_callback GetTimeSinceLastVsync;
	/** C type : GetD3D9AdapterIndex_callback* */
	public VR_IVRSystem_FnTable.GetD3D9AdapterIndex_callback GetD3D9AdapterIndex;
	/** C type : GetDXGIOutputInfo_callback* */
	public com.jme3.system.jopenvr.VR_IVRExtendedDisplay_FnTable.GetDXGIOutputInfo_callback GetDXGIOutputInfo;
	/** C type : GetOutputDevice_callback* */
	public VR_IVRSystem_FnTable.GetOutputDevice_callback GetOutputDevice;
	/** C type : IsDisplayOnDesktop_callback* */
	public VR_IVRSystem_FnTable.IsDisplayOnDesktop_callback IsDisplayOnDesktop;
	/** C type : SetDisplayVisibility_callback* */
	public VR_IVRSystem_FnTable.SetDisplayVisibility_callback SetDisplayVisibility;
	/** C type : GetDeviceToAbsoluteTrackingPose_callback* */
	public VR_IVRSystem_FnTable.GetDeviceToAbsoluteTrackingPose_callback GetDeviceToAbsoluteTrackingPose;
	/** C type : ResetSeatedZeroPose_callback* */
	public VR_IVRSystem_FnTable.ResetSeatedZeroPose_callback ResetSeatedZeroPose;
	/** C type : GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback* */
	public VR_IVRSystem_FnTable.GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback GetSeatedZeroPoseToStandingAbsoluteTrackingPose;
	/** C type : GetRawZeroPoseToStandingAbsoluteTrackingPose_callback* */
	public VR_IVRSystem_FnTable.GetRawZeroPoseToStandingAbsoluteTrackingPose_callback GetRawZeroPoseToStandingAbsoluteTrackingPose;
	/** C type : GetSortedTrackedDeviceIndicesOfClass_callback* */
	public VR_IVRSystem_FnTable.GetSortedTrackedDeviceIndicesOfClass_callback GetSortedTrackedDeviceIndicesOfClass;
	/** C type : GetTrackedDeviceActivityLevel_callback* */
	public VR_IVRSystem_FnTable.GetTrackedDeviceActivityLevel_callback GetTrackedDeviceActivityLevel;
	/** C type : ApplyTransform_callback* */
	public VR_IVRSystem_FnTable.ApplyTransform_callback ApplyTransform;
	/** C type : GetTrackedDeviceIndexForControllerRole_callback* */
	public VR_IVRSystem_FnTable.GetTrackedDeviceIndexForControllerRole_callback GetTrackedDeviceIndexForControllerRole;
	/** C type : GetControllerRoleForTrackedDeviceIndex_callback* */
	public VR_IVRSystem_FnTable.GetControllerRoleForTrackedDeviceIndex_callback GetControllerRoleForTrackedDeviceIndex;
	/** C type : GetTrackedDeviceClass_callback* */
	public VR_IVRSystem_FnTable.GetTrackedDeviceClass_callback GetTrackedDeviceClass;
	/** C type : IsTrackedDeviceConnected_callback* */
	public VR_IVRSystem_FnTable.IsTrackedDeviceConnected_callback IsTrackedDeviceConnected;
	/** C type : GetBoolTrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetBoolTrackedDeviceProperty_callback GetBoolTrackedDeviceProperty;
	/** C type : GetFloatTrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetFloatTrackedDeviceProperty_callback GetFloatTrackedDeviceProperty;
	/** C type : GetInt32TrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetInt32TrackedDeviceProperty_callback GetInt32TrackedDeviceProperty;
	/** C type : GetUint64TrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetUint64TrackedDeviceProperty_callback GetUint64TrackedDeviceProperty;
	/** C type : GetMatrix34TrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetMatrix34TrackedDeviceProperty_callback GetMatrix34TrackedDeviceProperty;
	/** C type : GetStringTrackedDeviceProperty_callback* */
	public VR_IVRSystem_FnTable.GetStringTrackedDeviceProperty_callback GetStringTrackedDeviceProperty;
	/** C type : GetPropErrorNameFromEnum_callback* */
	public VR_IVRSystem_FnTable.GetPropErrorNameFromEnum_callback GetPropErrorNameFromEnum;
	/** C type : PollNextEvent_callback* */
	public VR_IVRSystem_FnTable.PollNextEvent_callback PollNextEvent;
	/** C type : PollNextEventWithPose_callback* */
	public VR_IVRSystem_FnTable.PollNextEventWithPose_callback PollNextEventWithPose;
	/** C type : GetEventTypeNameFromEnum_callback* */
	public VR_IVRSystem_FnTable.GetEventTypeNameFromEnum_callback GetEventTypeNameFromEnum;
	/** C type : GetHiddenAreaMesh_callback* */
	public VR_IVRSystem_FnTable.GetHiddenAreaMesh_callback GetHiddenAreaMesh;
	/** C type : GetControllerState_callback* */
	public VR_IVRSystem_FnTable.GetControllerState_callback GetControllerState;
	/** C type : GetControllerStateWithPose_callback* */
	public VR_IVRSystem_FnTable.GetControllerStateWithPose_callback GetControllerStateWithPose;
	/** C type : TriggerHapticPulse_callback* */
	public VR_IVRSystem_FnTable.TriggerHapticPulse_callback TriggerHapticPulse;
	/** C type : GetButtonIdNameFromEnum_callback* */
	public VR_IVRSystem_FnTable.GetButtonIdNameFromEnum_callback GetButtonIdNameFromEnum;
	/** C type : GetControllerAxisTypeNameFromEnum_callback* */
	public VR_IVRSystem_FnTable.GetControllerAxisTypeNameFromEnum_callback GetControllerAxisTypeNameFromEnum;
	/** C type : CaptureInputFocus_callback* */
	public VR_IVRSystem_FnTable.CaptureInputFocus_callback CaptureInputFocus;
	/** C type : ReleaseInputFocus_callback* */
	public VR_IVRSystem_FnTable.ReleaseInputFocus_callback ReleaseInputFocus;
	/** C type : IsInputFocusCapturedByAnotherProcess_callback* */
	public VR_IVRSystem_FnTable.IsInputFocusCapturedByAnotherProcess_callback IsInputFocusCapturedByAnotherProcess;
	/** C type : DriverDebugRequest_callback* */
	public VR_IVRSystem_FnTable.DriverDebugRequest_callback DriverDebugRequest;
	/** C type : PerformFirmwareUpdate_callback* */
	public VR_IVRSystem_FnTable.PerformFirmwareUpdate_callback PerformFirmwareUpdate;
	/** C type : AcknowledgeQuit_Exiting_callback* */
	public VR_IVRSystem_FnTable.AcknowledgeQuit_Exiting_callback AcknowledgeQuit_Exiting;
	/** C type : AcknowledgeQuit_UserPrompt_callback* */
	public VR_IVRSystem_FnTable.AcknowledgeQuit_UserPrompt_callback AcknowledgeQuit_UserPrompt;
	/** <i>native declaration : headers\openvr_capi.h:1371</i> */
	public interface GetRecommendedRenderTargetSize_callback extends Callback {
		void apply(IntByReference pnWidth, IntByReference pnHeight);
	};
	/** <i>native declaration : headers\openvr_capi.h:1372</i> */
	public interface GetProjectionMatrix_callback extends Callback {
		com.jme3.system.jopenvr.HmdMatrix44_t.ByValue apply(int eEye, float fNearZ, float fFarZ);
	};
	/** <i>native declaration : headers\openvr_capi.h:1373</i> */
	public interface GetProjectionRaw_callback extends Callback {
		void apply(int eEye, FloatByReference pfLeft, FloatByReference pfRight, FloatByReference pfTop, FloatByReference pfBottom);
	};
	/** <i>native declaration : headers\openvr_capi.h:1374</i> */	
	public interface ComputeDistortion_callback extends Callback {
		byte apply(int eEye, float fU, float fV, DistortionCoordinates_t pDistortionCoordinates);
	};
	
	/** <i>native declaration : headers\openvr_capi.h:1375</i> */
	public interface GetEyeToHeadTransform_callback extends Callback {
		HmdMatrix34_t.ByValue apply(int eEye);
	};
	/** <i>native declaration : headers\openvr_capi.h:1376</i> */
	public interface GetTimeSinceLastVsync_callback extends Callback {
		byte apply(FloatByReference pfSecondsSinceLastVsync, LongByReference pulFrameCounter);
	};
	/** <i>native declaration : headers\openvr_capi.h:1377</i> */
	public interface GetD3D9AdapterIndex_callback extends Callback {
		int apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1378</i> */
	public interface GetDXGIOutputInfo_callback extends Callback {
		void apply(IntByReference pnAdapterIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1379</i> */
	public interface GetOutputDevice_callback extends Callback {
		void apply(LongByReference pnDevice, int textureType);
	};
	/** <i>native declaration : headers\openvr_capi.h:1380</i> */
	public interface IsDisplayOnDesktop_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1381</i> */
	public interface SetDisplayVisibility_callback extends Callback {
		byte apply(byte bIsVisibleOnDesktop);
	};
	/** <i>native declaration : headers\openvr_capi.h:1382</i> */
	public interface GetDeviceToAbsoluteTrackingPose_callback extends Callback {
		void apply(int eOrigin, float fPredictedSecondsToPhotonsFromNow, TrackedDevicePose_t pTrackedDevicePoseArray, int unTrackedDevicePoseArrayCount);
	};
	/** <i>native declaration : headers\openvr_capi.h:1383</i> */
	public interface ResetSeatedZeroPose_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1384</i> */
	public interface GetSeatedZeroPoseToStandingAbsoluteTrackingPose_callback extends Callback {
		HmdMatrix34_t.ByValue apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1385</i> */
	public interface GetRawZeroPoseToStandingAbsoluteTrackingPose_callback extends Callback {
		HmdMatrix34_t.ByValue apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1386</i> */
	public interface GetSortedTrackedDeviceIndicesOfClass_callback extends Callback {
		int apply(int eTrackedDeviceClass, IntByReference punTrackedDeviceIndexArray, int unTrackedDeviceIndexArrayCount, int unRelativeToTrackedDeviceIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1387</i> */
	public interface GetTrackedDeviceActivityLevel_callback extends Callback {
		int apply(int unDeviceId);
	};
	/** <i>native declaration : headers\openvr_capi.h:1388</i> */
	public interface ApplyTransform_callback extends Callback {
		void apply(TrackedDevicePose_t pOutputPose, TrackedDevicePose_t pTrackedDevicePose, HmdMatrix34_t pTransform);
	};
	/** <i>native declaration : headers\openvr_capi.h:1389</i> */
	public interface GetTrackedDeviceIndexForControllerRole_callback extends Callback {
		int apply(int unDeviceType);
	};
	/** <i>native declaration : headers\openvr_capi.h:1390</i> */
	public interface GetControllerRoleForTrackedDeviceIndex_callback extends Callback {
		int apply(int unDeviceIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1391</i> */
	public interface GetTrackedDeviceClass_callback extends Callback {
		int apply(int unDeviceIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1392</i> */
	public interface IsTrackedDeviceConnected_callback extends Callback {
		byte apply(int unDeviceIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1393</i> */
	public interface GetBoolTrackedDeviceProperty_callback extends Callback {
		byte apply(int unDeviceIndex, int prop, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1394</i> */
	public interface GetFloatTrackedDeviceProperty_callback extends Callback {
		float apply(int unDeviceIndex, int prop, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1395</i> */
	public interface GetInt32TrackedDeviceProperty_callback extends Callback {
		int apply(int unDeviceIndex, int prop, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1396</i> */
	public interface GetUint64TrackedDeviceProperty_callback extends Callback {
		long apply(int unDeviceIndex, int prop, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1397</i> */
	public interface GetMatrix34TrackedDeviceProperty_callback extends Callback {
		HmdMatrix34_t.ByValue apply(int unDeviceIndex, int prop, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1398</i> */
	public interface GetStringTrackedDeviceProperty_callback extends Callback {
		int apply(int unDeviceIndex, int prop, Pointer pchValue, int unBufferSize, IntByReference pError);
	};
	/** <i>native declaration : headers\openvr_capi.h:1399</i> */
	public interface GetPropErrorNameFromEnum_callback extends Callback {
		Pointer apply(int error);
	};
	/** <i>native declaration : headers\openvr_capi.h:1400</i> */
	public interface PollNextEvent_callback extends Callback {
		byte apply(VREvent_t pEvent, int uncbVREvent);
	};
	/** <i>native declaration : headers\openvr_capi.h:1401</i> */
	public interface PollNextEventWithPose_callback extends Callback {
		byte apply(int eOrigin, VREvent_t pEvent, int uncbVREvent, TrackedDevicePose_t pTrackedDevicePose);
	};
	/** <i>native declaration : headers\openvr_capi.h:1402</i> */
	public interface GetEventTypeNameFromEnum_callback extends Callback {
		Pointer apply(int eType);
	};
	/** <i>native declaration : headers\openvr_capi.h:1403</i> */
	public interface GetHiddenAreaMesh_callback extends Callback {
		com.jme3.system.jopenvr.HiddenAreaMesh_t.ByValue apply(int eEye, int type);
	};
	/** <i>native declaration : headers\openvr_capi.h:1404</i> */
	public interface GetControllerState_callback extends Callback {
		byte apply(int unControllerDeviceIndex, VRControllerState_t pControllerState, int unControllerStateSize);
	};
	/** <i>native declaration : headers\openvr_capi.h:1405</i> */
	public interface GetControllerStateWithPose_callback extends Callback {
		byte apply(int eOrigin, int unControllerDeviceIndex, VRControllerState_t pControllerState, int unControllerStateSize, TrackedDevicePose_t pTrackedDevicePose);
	};
	/** <i>native declaration : headers\openvr_capi.h:1406</i> */
	public interface TriggerHapticPulse_callback extends Callback {
		void apply(int unControllerDeviceIndex, int unAxisId, short usDurationMicroSec);
	};
	/** <i>native declaration : headers\openvr_capi.h:1407</i> */
	public interface GetButtonIdNameFromEnum_callback extends Callback {
		Pointer apply(int eButtonId);
	};
	/** <i>native declaration : headers\openvr_capi.h:1408</i> */
	public interface GetControllerAxisTypeNameFromEnum_callback extends Callback {
		Pointer apply(int eAxisType);
	};
	/** <i>native declaration : headers\openvr_capi.h:1409</i> */
	public interface CaptureInputFocus_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1410</i> */
	public interface ReleaseInputFocus_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1411</i> */
	public interface IsInputFocusCapturedByAnotherProcess_callback extends Callback {
		byte apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1412</i> */
	public interface DriverDebugRequest_callback extends Callback {
		int apply(int unDeviceIndex, Pointer pchRequest, Pointer pchResponseBuffer, int unResponseBufferSize);
	};
	/** <i>native declaration : headers\openvr_capi.h:1413</i> */
	public interface PerformFirmwareUpdate_callback extends Callback {
		int apply(int unDeviceIndex);
	};
	/** <i>native declaration : headers\openvr_capi.h:1414</i> */
	public interface AcknowledgeQuit_Exiting_callback extends Callback {
		void apply();
	};
	/** <i>native declaration : headers\openvr_capi.h:1415</i> */
	public interface AcknowledgeQuit_UserPrompt_callback extends Callback {
		void apply();
	};
	public VR_IVRSystem_FnTable() {
		super();
	}
	protected List<String> getFieldOrder() {
		//return Arrays.asList("GetRecommendedRenderTargetSize", "GetProjectionMatrix", "GetProjectionRaw", "ComputeDistortion", "GetEyeToHeadTransform", "GetTimeSinceLastVsync", "GetD3D9AdapterIndex", "GetDXGIOutputInfo", "GetOutputDevice", "IsDisplayOnDesktop", "SetDisplayVisibility", "GetDeviceToAbsoluteTrackingPose", "ResetSeatedZeroPose", "GetSeatedZeroPoseToStandingAbsoluteTrackingPose", "GetRawZeroPoseToStandingAbsoluteTrackingPose", "GetSortedTrackedDeviceIndicesOfClass", "GetTrackedDeviceActivityLevel", "ApplyTransform", "GetTrackedDeviceIndexForControllerRole", "GetControllerRoleForTrackedDeviceIndex", "GetTrackedDeviceClass", "IsTrackedDeviceConnected", "GetBoolTrackedDeviceProperty", "GetFloatTrackedDeviceProperty", "GetInt32TrackedDeviceProperty", "GetUint64TrackedDeviceProperty", "GetMatrix34TrackedDeviceProperty", "GetStringTrackedDeviceProperty", "GetPropErrorNameFromEnum", "PollNextEvent", "PollNextEventWithPose", "GetEventTypeNameFromEnum", "GetHiddenAreaMesh", "GetControllerState", "GetControllerStateWithPose", "TriggerHapticPulse", "GetButtonIdNameFromEnum", "GetControllerAxisTypeNameFromEnum", "CaptureInputFocus", "ReleaseInputFocus", "IsInputFocusCapturedByAnotherProcess", "DriverDebugRequest", "PerformFirmwareUpdate", "AcknowledgeQuit_Exiting", "AcknowledgeQuit_UserPrompt");
	
		return Arrays.asList("GetRecommendedRenderTargetSize", 
				"GetProjectionMatrix", 
				"GetProjectionRaw", 
				"ComputeDistortion", 
				"GetEyeToHeadTransform", 
				"GetTimeSinceLastVsync", 
				"GetD3D9AdapterIndex", 
				"GetDXGIOutputInfo", 
				"GetOutputDevice", 
				"IsDisplayOnDesktop", 
				"SetDisplayVisibility", 
				"GetDeviceToAbsoluteTrackingPose", 
				"ResetSeatedZeroPose", 
				"GetSeatedZeroPoseToStandingAbsoluteTrackingPose", 
				"GetRawZeroPoseToStandingAbsoluteTrackingPose", 
				"GetSortedTrackedDeviceIndicesOfClass", 
				"GetTrackedDeviceActivityLevel", 
				"ApplyTransform", 
				"GetTrackedDeviceIndexForControllerRole", 
				"GetControllerRoleForTrackedDeviceIndex", 
				"GetTrackedDeviceClass", 
				"IsTrackedDeviceConnected", 
				"GetBoolTrackedDeviceProperty", 
				"GetFloatTrackedDeviceProperty", 
				"GetInt32TrackedDeviceProperty", 
				"GetUint64TrackedDeviceProperty", 
				"GetMatrix34TrackedDeviceProperty", 
				"GetStringTrackedDeviceProperty", 
				"GetPropErrorNameFromEnum", 
				"PollNextEvent", 
				"PollNextEventWithPose", 
				"GetEventTypeNameFromEnum", 
				"GetHiddenAreaMesh", 
				"GetControllerState", 
				"GetControllerStateWithPose", 
				"TriggerHapticPulse", 
				"GetButtonIdNameFromEnum", 
				"GetControllerAxisTypeNameFromEnum", 
				"CaptureInputFocus", 
				"ReleaseInputFocus", 
				"IsInputFocusCapturedByAnotherProcess", 
				"DriverDebugRequest", 
				"PerformFirmwareUpdate", 
				"AcknowledgeQuit_Exiting", 
				"AcknowledgeQuit_UserPrompt");
	}
	public VR_IVRSystem_FnTable(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VR_IVRSystem_FnTable implements Structure.ByReference {
		
	};
	public static class ByValue extends VR_IVRSystem_FnTable implements Structure.ByValue {
		
	};
}
