/**
 * Copyright (C) 2018 Mike Hummel (mh@mhus.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.mhus.app.reactive.examples.simple1.forms;

import org.summerclouds.common.core.M;
import org.summerclouds.common.core.consts.GenerateConst;
import org.summerclouds.common.core.error.MException;
import org.summerclouds.common.core.form.DefAttribute;
import org.summerclouds.common.core.form.DefRoot;
import org.summerclouds.common.core.form.Item;
import org.summerclouds.common.core.form.definition.FaReadOnly;
import org.summerclouds.common.core.form.definition.FmAction;
import org.summerclouds.common.core.form.definition.FmCombobox;
import org.summerclouds.common.core.form.definition.FmText;
import org.summerclouds.common.core.pojo.Public;

import de.mhus.app.reactive.examples.simple1.S1Pool;
import de.mhus.app.reactive.examples.simple1.S1TheEnd;
import de.mhus.app.reactive.examples.simple1._S1Pool;
import de.mhus.app.reactive.model.annotations.ActivityDescription;
import de.mhus.app.reactive.model.annotations.Output;
import de.mhus.app.reactive.model.annotations.PropertyDescription;
import de.mhus.app.reactive.util.bpmn2.RUserTask;

@ActivityDescription(
        displayName = "Complex User Form 01",
        outputs = @Output(activity = S1TheEnd.class))
@GenerateConst
public class S1UserForm01 extends RUserTask<S1Pool> {

    @PropertyDescription private String text3 = "text3";
    @PropertyDescription private String option = "1";

    @PropertyDescription(persistent = false)
    @Public(name = "option.items")
    private Item[] optionOptions =
            new Item[] {
                new Item("1", "One"), new Item("2", "Two"),
            };

    @Override
    public DefRoot getForm() {
        return new DefRoot(
                new DefAttribute("showInformation", true),
                new FmText(M.n(_S1Pool._TEXT1), "Text1", "", new FaReadOnly()),
                new FmText(M.n(_S1Pool._TEXT2), "Text2", ""),
                new FmText(M.n(_S1UserForm01._TEXT3), "Text3", ""),
                new FmCombobox("option", "Option", "Sample Option with options"),
                new FmAction("submit", "submit:action=submit", "Submit", "Send"));
    }

    @Override
    public String[] createIndexValues(boolean init) {
        return null;
    }

    @Override
    protected void doSubmit() throws MException {}

    public String getText3() {
        return text3;
    }
}
