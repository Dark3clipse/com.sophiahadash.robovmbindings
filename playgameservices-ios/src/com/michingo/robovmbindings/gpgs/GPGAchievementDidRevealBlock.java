package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGAchievementDidRevealBlock)(GPGAchievementState state, NSError *error);
@Marshaler(GPGAchievementDidRevealBlock.Marshaler.class)
public interface GPGAchievementDidRevealBlock {

    /**
     * Runs this block.
     */
    void invoke(GPGAchievementState state, NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, GPGAchievementState state, NSError error) {
            ((GPGAchievementDidRevealBlock) block.object()).invoke(state, error);
        }
    }
    
    static class Marshaler {
        private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);
        public static @Pointer long toNative(Object o) {
            return WRAPPER.toNative(o);
        }
        public static void updateObject(Object o, long handle) {}
    }
}