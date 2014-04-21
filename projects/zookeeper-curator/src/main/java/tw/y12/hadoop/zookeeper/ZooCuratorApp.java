/*
 * Copyright 2014 Y12STUDIO
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
package tw.y12.hadoop.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZooCuratorApp {

	public static void main(String[] args) {
		System.out.println("hello zookeeper/curator");
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		String zkconn = "127.0.0.1:2181";
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkconn,
				retryPolicy);
		client.start();

	}

}
