/*

This file is part of Roboject

Copyright (c) 2010-2011 akquinet A.G.

Contact:  http://www.akquinet.de/en

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.akquinet.android.robojecttest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.akquinet.android.roboject.RobojectFragment;
import de.akquinet.android.roboject.ServiceRegistry;
import de.akquinet.android.roboject.annotations.InjectService;
import de.akquinet.android.robojecttest.R;
import de.akquinet.android.robojecttest.services.AdderFragmentImplementation;

public class InjectNonAndroidServiceTestFragment extends RobojectFragment {
    static {
        ServiceRegistry.registerService(AdderInterface.class, AdderFragmentImplementation.class);
    }

    @InjectService
    public AdderInterface adder1;

    public AdderInterface adder2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adder2 = ServiceRegistry.getService(AdderInterface.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.viewinject, container, false);
        return inflate;
    }

    public interface AdderInterface {
        int add(int... params);
    }
}
