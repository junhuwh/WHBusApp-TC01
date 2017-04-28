--drop table BUS_STOP_INFO;
--drop table BUS_LINE_INFO;

--select * from BUS_LINE_INFO;
--select * from BUS_STOP_INFO;

CREATE TABLE BUS_LINE_INFO (
ID                     INT,    --在系统里面的编号
LINE_NUM               VARCHAR(20),  --线路号
BUS_TYPE               VARCHAR(20), --IBM班车 园区公共班车
LICENSE_PLATE_NUM      VARCHAR(20),	--车牌号
DRIVER_NAME            VARCHAR(20),	--司机师傅姓名
DRIVER_PHONE_NUM       VARCHAR(20),	--司机师傅手机号
CAPTION_NAME           VARCHAR(20),	--车长姓名
CAPTION_EMAIL          VARCHAR(50),	--车长邮箱
CAPTION_PHONE_NUM      VARCHAR(20),	--车长手机号
SEATS                  INT	--班车座位数
);
CREATE TABLE BUS_STOP_INFO (
ID                    INT,  --班车在系统里面的编号
LINE_NUM              VARCHAR(20) ,	--线路号
BUS_TYPE              VARCHAR(20), --IBM班车 园区公共班车
STOP_NUM              VARCHAR(20),	--站点编号
STOP_NAME             VARCHAR(50),	--站点名称
STOP_TIME             TIME,		--停靠时间
STOP_DETAIL           VARCHAR(100)		--站点详细地址
);
insert into BUS_LINE_INFO 
  values(1,'11','ibm','鄂A1211','王师傅','13300000011','小张','si11@sss.com','13200001100','45');
insert into BUS_LINE_INFO 
 values(2,'12','ibm','鄂A1222','张师傅','13300000022','小王','si22@sss.com','13200002200','35');
insert into BUS_LINE_INFO 
  values(3,'13','ibm','鄂A1233','江师傅','13300000033','小赵','si33@sss.com','13200003300','20');
insert into BUS_LINE_INFO 
  values(4,'14','园区','鄂A1244','李师傅','13300000044','小李','si44@sss.com','13200004400','40');
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (1,'11','ibm','7:40','11a','循礼门','循礼门轻轨A出口today今天超市门口')                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (1,'11','ibm','7:46','11b','球场街','解放大道球场街公交站过50米解放大道新马路路口')     ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (1,'11','ibm','7:50','11c','永清街','解放大道永清街人行天桥下')                         ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (1,'11','ibm','7:55','11d','二七路','解放大道徐州新村地铁站前50m')                      ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL)  values (1,'11','ibm','8:05','','建设一路','建设一路公交站点前行50米中钢集团研究院门口')       ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL)  values (1,'11','ibm','8:50','','软件新城','')                                                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (2,'12','ibm','7:40','12a','循礼门','循礼门轻轨A出口today今天超市门口')                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (2,'12','ibm','7:46','12b','球场街','解放大道球场街公交站过50米解放大道新马路路口')     ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (2,'12','ibm','7:50','12c','永清街','解放大道永清街人行天桥下')                         ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (2,'12','ibm','7:55','12d','二七路','解放大道徐州新村地铁站前50m')                      ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL)  values (2,'12','ibm','8:50','','软件新城','')                                                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (3,'13','ibm','7:40','1a','循礼门','循礼门轻轨A出口today今天超市门口')                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (3,'13','ibm','7:46','1b','球场街','解放大道球场街公交站过50米解放大道新马路路口')     ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (3,'13','ibm','7:55','1d','二七路','解放大道徐州新村地铁站前50m')                      ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL)  values (3,'13','ibm','8:50','','软件新城','')                                                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (4,'11','园区','7:40','1a','循礼门','循礼门轻轨A出口today今天超市门口')                 ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (4,'11','园区','7:50','1c','永清街','解放大道永清街人行天桥下')                         ;
insert into BUS_STOP_INFO (ID,LINE_NUM,BUS_TYPE,STOP_TIME,STOP_NUM,STOP_NAME,STOP_DETAIL) values (4,'11','园区','8:50','','软件新城','')                                                 ;
