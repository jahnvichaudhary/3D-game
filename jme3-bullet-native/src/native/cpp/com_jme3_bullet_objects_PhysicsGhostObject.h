/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_jme3_bullet_objects_PhysicsGhostObject */

#ifndef _Included_com_jme3_bullet_objects_PhysicsGhostObject
#define _Included_com_jme3_bullet_objects_PhysicsGhostObject
#ifdef __cplusplus
extern "C" {
#endif
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_NONE
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_NONE 0L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_01
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_01 1L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_02
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_02 2L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_03
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_03 4L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_04
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_04 8L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_05
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_05 16L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_06
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_06 32L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_07
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_07 64L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_08
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_08 128L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_09
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_09 256L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_10
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_10 512L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_11
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_11 1024L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_12
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_12 2048L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_13
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_13 4096L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_14
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_14 8192L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_15
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_15 16384L
#undef com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_16
#define com_jme3_bullet_objects_PhysicsGhostObject_COLLISION_GROUP_16 32768L
/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    createGhostObject
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_createGhostObject
  (JNIEnv *, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setGhostFlags
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setGhostFlags
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setPhysicsLocation
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setPhysicsLocation
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setPhysicsRotation
 * Signature: (JLcom/jme3/math/Matrix3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setPhysicsRotation__JLcom_jme3_math_Matrix3f_2
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setPhysicsRotation
 * Signature: (JLcom/jme3/math/Quaternion;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setPhysicsRotation__JLcom_jme3_math_Quaternion_2
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getPhysicsLocation
 * Signature: (JLcom/jme3/math/Vector3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getPhysicsLocation
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getPhysicsRotation
 * Signature: (JLcom/jme3/math/Quaternion;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getPhysicsRotation
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getPhysicsRotationMatrix
 * Signature: (JLcom/jme3/math/Matrix3f;)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getPhysicsRotationMatrix
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getOverlappingObjects
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getOverlappingObjects
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getOverlappingCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getOverlappingCount
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setCcdSweptSphereRadius
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setCcdSweptSphereRadius
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    setCcdMotionThreshold
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_setCcdMotionThreshold
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getCcdSweptSphereRadius
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getCcdSweptSphereRadius
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getCcdMotionThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getCcdMotionThreshold
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_jme3_bullet_objects_PhysicsGhostObject
 * Method:    getCcdSquareMotionThreshold
 * Signature: (J)F
 */
JNIEXPORT jfloat JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_getCcdSquareMotionThreshold
  (JNIEnv *, jobject, jlong);

/*
* Class:     com_jme3_bullet_objects_PhysicsGhostObject
* Method : rayTest_native
* Signature : (Lcom / jme3 / math / Vector3f; Lcom / jme3 / math / Vector3f; JLjava / util / List;)V
*/
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_rayTest_1native
(JNIEnv *, jobject, jobject, jobject, jlong, jobject, jint);

/*
* Class:     com_jme3_bullet_objects_PhysicsGhostObject
* Method : sweepTest_native
* Signature: (J;L;Lcom/jme3/math/Transform;Lcom/jme3/math/Transform;L;JLjava/util/List;F)V
*/
JNIEXPORT void JNICALL Java_com_jme3_bullet_objects_PhysicsGhostObject_sweepTest_1native
(JNIEnv *, jobject, jlong, jobject, jobject, jlong, jobject, jfloat);

#ifdef __cplusplus
}
#endif
#endif
