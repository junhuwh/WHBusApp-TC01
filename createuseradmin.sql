--drop table BUS_STOP_INFO;
--drop table BUS_LINE_INFO;

--select * from BUS_LINE_INFO;
--select * from BUS_STOP_INFO;

CREATE TABLE BUS_APP_USER (
ID                     INT,    --在系统里面的编号
USERNAME               VARCHAR(20),  --线路号
PASSWORD               VARCHAR(20), --IBM班车 园区公共班车
EMAIL                  VARCHAR(20),	--车牌号
NICKNAME               VARCHAR(20),	--司机师傅姓名
REGISTER_DATE          TIMESTAMP,
IS_ADM                 BOOLEAN,
ADM_DATE               TIMESTAMP
);

