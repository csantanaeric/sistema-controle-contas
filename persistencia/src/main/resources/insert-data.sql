INSERT INTO TRANSACAO (DT_TRANSACAO,VL_TRANSACAO) values (CURRENT_TIMESTAMP, 10.0 );


INSERT INTO PESSOA_JURIDICA (RAZAO_SOCIAL,NOME_FANTASIA,CNPJ) VALUES ('HUBFINTECH','VALE PRESENTE','132132100000001-1');
INSERT INTO CONTA_PESSOA (PESSOA_FISICA_ID,PESSOA_JURIDICA_ID) VALUES (NULL,1);


INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (NULL,'1',NULL,1,'J',CURRENT_TIMESTAMP,'A');--1
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (1,1000.0,CURRENT_TIMESTAMP);--1

INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (1,'11',1,1,'J',CURRENT_TIMESTAMP,'A');--2
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (2,1000.0,  cast({fn timestampadd(SQL_TSI_DAY, -2, current_timestamp)} as timestamp) );--2
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (2,4000.0,  cast({fn timestampadd(SQL_TSI_DAY, -1, current_timestamp)} as timestamp) );--2
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (2,5200.0,CURRENT_TIMESTAMP);--2


INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (2,'111',1,1,'J',CURRENT_TIMESTAMP,'A');--3
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (3,1000.0,CURRENT_TIMESTAMP);--3

INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (2,'112',1,1,'J',CURRENT_TIMESTAMP,'A');--4
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (4,1000.0,CURRENT_TIMESTAMP);--4


INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (1,'12',1,1,'J',CURRENT_TIMESTAMP,'A');--5
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (5,1000.0,CURRENT_TIMESTAMP);--5

INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (5,'121',1,1,'J',CURRENT_TIMESTAMP,'A');--6
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (6,1000.0,CURRENT_TIMESTAMP);--6


INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (NULL,'2',NULL,1,'J',CURRENT_TIMESTAMP,'A');--7
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (7,1000.0,CURRENT_TIMESTAMP);--7

INSERT INTO CONTA (CONTA_PAI_ID,NOME,CONTA_PAI_MATRIZ_ID,CONTA_PESSOA_ID,TP_PESSOA,DT_CRIACAO,STATUS) VALUES  (7,'2',NULL,1,'J',CURRENT_TIMESTAMP,'A');--8
INSERT INTO SALDO (CONTA_ID,SALDO,DH_ATUALIZACAO) VALUES  (8,1000.0,CURRENT_TIMESTAMP);--8

INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (1, '2017-06-14 02:03:59','e25fe2f1e40a74c43a09bf2937611ab4');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (2, '2017-06-14 02:04:14', 'e25fe2f1e40a74c43a09bf2937611a');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (3, '2017-06-14 02:04:24', 'e25fe2f1e40a74c43a09bf2937611');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (4, '2017-06-14 02:04:33', 'e25fe2f1e40a74c43a09bf293761');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (5, '2017-06-15 20:30:37', 'e25fe2f1e40a74c43a09bf29376');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (6, '2017-06-15 20:40:06', 'e25fe2f1e40a74c43a09bf2937');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (7, '2017-06-15 20:42:27', 'e25fe2f1e40a74c43a09bf293');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (8, '2017-06-15 20:52:16', 'e25fe2f1e40a74c43a09bf29');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (9, '2017-06-15 20:59:18', 'e25fe2f1e40a74c43a09bf');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (10, '2017-06-15 21:04:10', 'e25fe2f1e40a74c43a09');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (11, '2017-06-15 21:06:02', 'e25fe2f1e40a74c43a0');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (12, '2017-06-15 21:40:19', 'e25fe2f1e40a74c43a');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (13, '2017-06-15 21:40:19', 'e25fe2f1e40a74c43');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (14, '2017-06-15 21:49:50', 'e25fe2f1e40a74c4');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (15, '2017-06-15 21:49:54', 'e25fe2f1e40a74c');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (16, '2017-06-15 22:25:50', 'e25fe2f1e40a7');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (17, '2017-06-15 22:29:44', 'e25fe2f1e40');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (18, '2017-06-15 22:35:23', 'e25fe2f1e4');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (19, '2017-06-15 22:35:50', 'e25fe2f1e');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (20, '2017-06-15 22:42:13', 'e25fe2f');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (21, '2017-06-15 22:51:04', 'e25fe2');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (22, '2017-06-15 22:56:44', 'e25f');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (23, '2017-06-15 23:04:39', 'e25');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (24, '2017-06-15 23:07:19', 'e');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (25, '2017-06-15 23:09:01', 'e22');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (26, '2017-06-15 23:11:18', 'e222');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (27, '2017-06-15 23:13:52', 'e2222');
INSERT INTO transacao (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `CD_APORTE`) VALUES (28, '2017-06-15 23:43:54', 'e22222');



INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (1, 10, 'A', 0, '2017-06-15 21:04:10', 500.1);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (2, 10, 'A', 0, '2017-06-15 21:04:10', 500.1);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (3, 12, 'A', 0, '2017-06-15 21:40:19', 100);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (4, 14, 'A', 0, '2017-06-15 21:49:50', 100);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (11, 27, 'A', 1, '2017-06-15 23:13:52', 50.5);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (10, 26, 'A', 1, '2017-06-15 23:08:20', 10000);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (9, 24, 'A', 1, '2017-06-15 23:07:19', 10000);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (8, 23, 'A', 1, '2017-06-15 23:04:39', 10000);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (7, 22, 'A', 1, '2017-06-15 22:56:38', 500.1);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (6, 21, 'A', 1, '2017-06-15 22:51:04', 500.1);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (5, 20, 'A', 1, '2017-06-15 22:42:05', 500.1);
INSERT INTO operacao (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES (12, 28, 'A', 1, '2017-06-15 23:43:54', 10000);





	

