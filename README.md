# RPCDemo
基于socket的RPC实现方式，使用proxy代理实现

## 项目简介

该项目是基于socket和proxy代理实现的基本PRC调用，分别定义 `Producer` 和 `Consumer` ,使用网络环境满足远程调用任意接口的需求。

## 功能特性

## 环境依赖

- 需要JDK8及以上环境
- 需要JAVA开发IDE，推荐Intellij IDEA

## 部署步骤

1. `git clone https://github.com/fchange/RPCDemo.git`
2. 使用IDEA打开项目
3. 找到producer包，运行Producer（其会开启一个socket server）。
4. 找到consumer包，运行ConSumer（其会在每次需要RPC时，发起一个socket连接）。

## 目录结构描述

 - hitokoto-api包， 定义接口及domain，不涉及接口的实现，service定义提供随机返回一个“一言”的接口。
 - consumer包，依赖hitokoto-api，尝试通过代理获得一个IHitokotoService的代理对象，而代理对象的invoke，会发起一个socket链接以获得远程服务返回的数据。
 - producer包，依赖hitokoto-api并实现对应接口。run producer 会开启一个socket server， 在获得socket链接时，调用对应的实现类并返回具体结果给socket连接。

##  版本内容更新

V1.0.0 初始化，尝试RPC架构
