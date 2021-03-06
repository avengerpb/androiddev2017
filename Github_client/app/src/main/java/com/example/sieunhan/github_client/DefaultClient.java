/*
 * Copyright 2012 GitHub Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sieunhan.github_client;

import org.eclipse.egit.github.core.client.GitHubClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;

/**
 * Default client used to communicate with GitHub API
 */
public class DefaultClient extends GitHubClient {

    private static final String USER_AGENT = "ForkHub/1.2";

    /**
     * Create client
     */
    public DefaultClient() {
        super();

        setSerializeNulls(false);
        setUserAgent(USER_AGENT);
    }

    /**
     * Create connection to URI
     *
     * @param uri
     * @return connection
     * @throws IOException
     */
    @Override
    protected HttpURLConnection createConnection(String uri) throws IOException {
        OkUrlFactory factory = new OkUrlFactory(new OkHttpClient());
        URL url = new URL(createUri(uri));
        return factory.open(url);
    }
}
