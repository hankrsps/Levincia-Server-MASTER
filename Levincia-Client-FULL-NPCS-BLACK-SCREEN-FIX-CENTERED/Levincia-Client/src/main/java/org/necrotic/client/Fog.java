package org.necrotic.client;

import org.necrotic.client.graphics.DrawingArea;

public class Fog {

    // Declare all fields as private, and consider renaming them for clarity
    private int begin = 2550;
    private int end = 3400;
    private int length = end - begin;

    public void setRange(int begin, int end) {
        // Check that the given range is valid
        if (begin >= end) {
            throw new IllegalArgumentException("Invalid fog range: begin must be less than end");
        }

        // Update the range and length fields
        this.begin = begin;
        this.end = end;
        this.length = end - begin;
    }

    public void draw(int rgb) {
        // Check that the fog color is valid
        if (rgb < 0 || rgb > 0xffffff) {
            throw new IllegalArgumentException("Invalid fog color: must be a 24-bit RGB value");
        }

        // Iterate over the DrawingArea's raster and depth buffer
        for (int i = 0; i < DrawingArea.raster.length; i++) {
            DrawingArea.raster[i] = blend(DrawingArea.raster[i], rgb, (DrawingArea.depthBuffer[i] - begin) / length);
        }
    }

    private int blend(int rgb1, int rgb2, float factor) {
        // Check that the blending factor is valid
        if (factor < 0 || factor > 1) {
            throw new IllegalArgumentException("Invalid blending factor: must be between 0 and 1");
        }

        // Return the blended color
        if (factor >= 1) {
            return rgb2;
        }
        if (factor <= 0) {
            return rgb1;
        }

        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = (rgb1) & 0xff;

        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = (rgb2) & 0xff;

        int r3 = r2 - r1;
        int g3 = g2 - g1;
        int b3 = b2 - b1;

        int r = (int) (r1 + (r3 * factor));
        int g = (int) (g1 + (g3 * factor));
        int b = (int) (b1 + (b3 * factor));

        return (r << 16) + (g << 8) + b;
    }
}