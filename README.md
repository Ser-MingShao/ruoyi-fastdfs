<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-dd77653d7c9f197dd9d93684f3c8dcfbab6.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi整合fastDFS实现文件存储</h1>
<h4 align="center">基于SpringBoot开发的轻量级Java快速开发框架</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi/stargazers"><img src="https://gitee.com/y_project/RuoYi/badge/star.svg?theme=gvp"></a>
	<a href="https://gitee.com/y_project/RuoYi"><img src="https://img.shields.io/badge/RuoYi-v4.7.7-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>


## 平台简介

+ 此项目采用RuoYi整合fastDFS，实现文件上传下载等操作
+ DFS服务器使用Docker自动部署
+ 服务器端口默认9999，有需要请自行更改

```dockerfile
docker run -d -p 9999:8080 -v /opt/go-fastdfs:/data -e GO_FASTDFS_DIR=/data sjqzhang/go-fastdfs
```

