package net.thewinnt.weit;

public final class Weit {
    public static final String MOD_ID = "weit";
    private static PlatformAbstractions PLATFORM;

    public static void init(PlatformAbstractions platform) {
        Weit.PLATFORM = platform;
        // Write common init code here.
    }

    public static PlatformAbstractions platform() {
        return PLATFORM;
    }
}
