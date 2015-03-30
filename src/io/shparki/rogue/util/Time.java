package io.shparki.rogue.util;

public class Time {
	
	public static final long SECOND = 1_000_000_000L;
	public static long getTime() { return System.nanoTime(); }
	
	private static long delta;
	public static long getDelta() { return delta; }
	public static void setDelta(long delta) { Time.delta = delta; }
	
	private static long updateLong;
	public static long getUpdateLong() { return updateLong; }
	public static void setUpdateLong(long updateLong) { Time.updateLong = updateLong; }
	public static double getUpdateRatio() { return (double)updateLong / SECOND;  }
	
	
	
	
}
