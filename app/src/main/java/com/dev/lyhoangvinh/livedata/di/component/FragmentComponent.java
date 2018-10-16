package com.dev.lyhoangvinh.livedata.di.component;

import android.content.Context;

import com.dev.lyhoangvinh.livedata.di.module.FragmentModule;
import com.dev.lyhoangvinh.livedata.di.qualifier.ApplicationContext;
import com.dev.lyhoangvinh.livedata.di.scopes.PerFragment;
import com.dev.lyhoangvinh.livedata.ui.collectionsNew.CollectionsNewFragment;

import dagger.Component;

/* Copyright 2016 Patrick Löwenstein
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
 * limitations under the License. */
@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(CollectionsNewFragment fragment);
}
