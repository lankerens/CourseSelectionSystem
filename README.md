# CourseSelectionSystem
基于 SSM 的学生在线选课系统 

<b>项目简介</b>：ssm + bootstrap + PageHelper. 


<a href="https://sm.ms/image/menHsCYM8DIhNUG" target="_blank"><img src="https://i.loli.net/2019/10/16/menHsCYM8DIhNUG.png" ></a>
<br>

目前粗略的完成大概的功能，只在正常的操作下不会出错，增删改查的数据验证还没写.


在最佳实践中，应当还应该返回与此操作相关的其他操作。比如，查询得到实体的响应中，应包含该实体的删除、更新操作的地址

如果业务上需要确保User对象的uname属性必填，如何实现呢？若将这类参数验证的代码写死在Controller中，势必会与正常的业务逻辑搅在一起，导致责任不够单一，违背于“单一责任原则”。建议将其参数验证行为从Controller中剥离出来，放到另外的类中


<h4>编写日志:</h4>

<b>2019.10.16</b>:  粗略完成了基本的功能, 很多验证功能没有完善.  

知识: JavaBean 的属性名的注意点, plugins 的顺序问题, Controller Server 的分工 等


希望下次 加上事务管理(回滚) 代码重复度较高,可以把许多类似的抽离出来封装成一个类, 自定义异常加强掌握
Map，ArrayList 等集合的初始化做的不够好， 可能资源浪费
转发和重定向 混乱
数据库访问次数太多，基本一次请求访问一次



<h4>主页面截图:</h4>
<a href="https://sm.ms/image/vj7APImyB9ewUOh" target="_blank"><img src="https://i.loli.net/2019/10/16/vj7APImyB9ewUOh.jpg" ></a>

<br>

<h4>学生:</h4>

<a href="https://sm.ms/image/YG9qNe7XlA3n6Ms" target="_blank"><img src="https://i.loli.net/2019/10/16/YG9qNe7XlA3n6Ms.png" ></a>

<br>
<a href="https://sm.ms/image/SXPMpFNKex6URg8" target="_blank"><img src="https://i.loli.net/2019/10/16/SXPMpFNKex6URg8.png" ></a>

<br>

<h4>教师:</h4>

<a href="https://sm.ms/image/zWvkEUHIomK46Re" target="_blank"><img src="https://i.loli.net/2019/10/16/zWvkEUHIomK46Re.png" ></a>
<br>

<a href="https://sm.ms/image/grwB53G2XaSocFy" target="_blank"><img src="https://i.loli.net/2019/10/16/grwB53G2XaSocFy.png" ></a>
<br>

<h4>管理员:</h4>

<a href="https://sm.ms/image/AapWPkCmvx8LeSu" target="_blank"><img src="https://i.loli.net/2019/10/16/AapWPkCmvx8LeSu.png" ></a>
<br>

<a href="https://sm.ms/image/3SkaMb9hfjEvr1y" target="_blank"><img src="https://i.loli.net/2019/10/16/3SkaMb9hfjEvr1y.png" ></a>
<br>
