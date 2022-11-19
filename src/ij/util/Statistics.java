package ij.util;
import ij.process.*;
import ij.measure.*;

public class Statistics {
    public static ImageStatistics getStatistics(ImageProcessor ip, int mOptions, Calibration cal) {
		Object pixels = ip.getPixels();
		if (pixels instanceof byte[])
			return new ByteStatistics(ip, mOptions, cal);
		else if (pixels instanceof short[])
			return new ShortStatistics(ip, mOptions, cal);
		else if (pixels instanceof int[])
			return new ColorStatistics(ip, mOptions, cal);
		else if (pixels instanceof float[])
			return new FloatStatistics(ip, mOptions, cal);
		else
			throw new IllegalArgumentException("Pixels are not byte, short, int or float");
	}

    
}
