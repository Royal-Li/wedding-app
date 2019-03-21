# wedding
婚礼旅拍
app启动端口 待定
后台启动端口 8181 

分为后端分为 app 后台   springboot + mybatis + mysql 
app apicloud + vue 后台 xadmin

url 定位资源 http 动词定义操作  

详情
	GET（SELECT）：从服务器取出资源（一项或多项）。
    POST（CREATE）：在服务器新建一个资源。
    PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）
    PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
    DELETE（DELETE）：从服务器删除资源。
例如	
	GET /zoos：列出所有动物园
    POST /zoos：新建一个动物园
    GET /zoos/ID：获取某个指定动物园的信息
    PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息
    PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
    DELETE /zoos/ID：删除某个动物园
    GET /zoos/ID/animals：列出某个指定动物园的所有动物
    DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物

方法名 查询queryUser
	  新建insertUser
	  更新updateUser
	  删除deleteUser
	  
	

