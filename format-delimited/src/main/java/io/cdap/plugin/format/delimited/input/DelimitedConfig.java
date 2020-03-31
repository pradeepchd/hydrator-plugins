/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.format.delimited.input;

import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.plugin.PluginPropertyField;
import io.cdap.plugin.format.input.PathTrackingConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Common config for delimited related formats
 */
public class DelimitedConfig extends PathTrackingConfig {
  public static final Map<String, PluginPropertyField> DELIMITED_FIELDS;
  private static final String ENABLE_QUOTES_DESC = "Whether to treat content between quotes as a value. " +
                                                     "Default value is false.";

  static {
    Map<String, PluginPropertyField> fields = new HashMap<>(FIELDS);
    fields.put("enableQuotedValues", new PluginPropertyField("filenameOnly", ENABLE_QUOTES_DESC,
                                                             "boolean", false, true));
    DELIMITED_FIELDS = Collections.unmodifiableMap(fields);
  }

  @Macro
  @Nullable
  @Description(ENABLE_QUOTES_DESC)
  protected Boolean enableQuotedValues;

  boolean getEnableQuotedValues() {
    return enableQuotedValues == null ? false : enableQuotedValues;
  }
}
