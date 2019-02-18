/*
 * Copyright 2019 Confluent Inc.
 *
 * Licensed under the Confluent Community License; you may not use this file
 * except in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.function.udf.url;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import java.net.URI;

@UdfDescription(name = UrlExtractQueryKudf.NAME, description = UrlExtractQueryKudf.DESCRIPTION)
public class UrlExtractQueryKudf {

  static final String DESCRIPTION = "Extracts the query parameters of an "
      + "application/x-www-form-urlencoded encoded String input, if it exists.";
  static final String NAME = "url_extract_query";

  @Udf(description = DESCRIPTION)
  public String extractQuery(
      @UdfParameter(description = "a valid URL to extract a query from")
      final String input) {
    return UrlParser.extract(input, URI::getQuery);
  }
}
