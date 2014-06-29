package com.viewsforandroid.foundry;

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link Foundry} that delegates to a collection of other foundries. The foundries are searched in order until a
 * typeface is found or there are no more foundries.
 */
class FoundryChain implements Foundry {

    private final List<Foundry> foundries = new ArrayList<>();

    public FoundryChain(final Foundry... foundries) {
        Collections.addAll(this.foundries, foundries);
    }

    @Override
    public Typeface getTypeface(final String name) {
        for (Foundry foundry : foundries) {
            Typeface result = foundry.getTypeface(name);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

}
