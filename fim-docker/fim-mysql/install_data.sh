#!/bin/bash
mysql -uroot -p$MYSQL_ROOT_PASSWORD <<EOF
source $WORK_PATH/$DDL_SQL;
source $WORK_PATH/DML_SQL;