/*
 * Copyright [2018]
 * 顺丰科技开源(opensource@sfmail.sf-express.com)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wzq.boot.service.impl;

import com.wzq.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * demo实现
 *
 * @author 顺丰科技开源(opensource @ sfmail.sf - express.com)
 * @version 1.0.0
 * @date 2018-12-03 13:50
 */
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hell0 " + name;
    }
}