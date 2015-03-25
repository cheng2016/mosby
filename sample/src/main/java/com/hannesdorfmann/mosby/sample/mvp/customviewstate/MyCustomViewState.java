/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hannesdorfmann.mosby.sample.mvp.customviewstate;

import android.os.Bundle;
import com.hannesdorfmann.mosby.mvp.viewstate.RestoreableViewState;

/**
 * @author Hannes Dorfmann
 */
public class MyCustomViewState implements RestoreableViewState<MyCustomView> {

  private final String BUNDLE_KEY = "MyCustomViewState";

  public boolean showingA = true; // if false, then show B

  @Override public void saveInstanceState(Bundle out) {
    out.putBoolean(BUNDLE_KEY, showingA);
  }

  @Override public boolean restoreInstanceState(Bundle in) {
    if (in == null) {
      return false;
    }

    showingA = in.getBoolean(BUNDLE_KEY, true);
    return true;
  }

  @Override public void apply(MyCustomView view, boolean retained) {

    if (showingA) {
      view.showA();
    } else {
      view.showB();
    }
  }

  /**
   * @param a true if showing a, false if showing b
   */
  public void setShowingA(boolean a) {
    this.showingA = a;
  }
}
