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

package com.hannesdorfmann.mosby.mvp.viewstate;

import android.support.v4.app.Fragment;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * I know, that word doesn't exist in english :)
 * <p>
 * I was looking for a word to say: The class that implements this interface has a {@link
 * ViewState}. It's just a common interface  for Activities and Fragments that support {@link
 * ViewState} that is used with the  {@link ViewStateManager} to rededuce code clones (copy and
 * pasting through subclasses)
 * </p>
 *
 * @author Hannes Dorfmann
 * @since 1.0.0
 */
public interface ViewStateSupport<V extends MvpView> {

  /**
   * Get the viewState
   */
  ViewState<V> getViewState();

  /**
   * Set the viewstate. <b>Should only be called by {@link ViewStateManager}</b>
   */
  void setViewState(ViewState<V> viewState);

  /**
   * Create the viewstate. Will be called by the {@link ViewStateManager}.
   */
  ViewState<V> createViewState();

  /**
   * This method will be called by {@link ViewStateManager} to inform that restoring the view state
   * is in progress.
   *
   * @param retstoringViewState true, if restoring viewstate is in progress, otherwise false
   */
  public void setRestoringViewState(boolean retstoringViewState);

  /**
   * @return true if the viewstate is restoring right now (not finished yet). Otherwise false.
   */
  public boolean isRestoringViewState();

  /**
   * Called if the {@link ViewState} instance has been restored successfully.
   * <p>
   * In this method you have to restore the viewstate by reading the view state properties and
   * setup
   * the view to be on the same state as before.
   * </p>
   *
   * @param instanceStateRetained true, if the viewstate has been retained by using{@link
   * Fragment#setRetainInstance(boolean)}, otherwise false (always false for activities).
   */
  public void onViewStateInstanceRestored(boolean instanceStateRetained);

  /**
   * Called if a new {@link ViewState} has been created because no viewstate from a previous
   * Activity or Fragment instance could be restored.
   * <p><b>Typically this is called on the first time the <i>Activity</i> or <i>Fragment</i> starts
   * and therefore no view state instance previously exists</b></p>
   */
  public void onNewViewStateInstance();
}
