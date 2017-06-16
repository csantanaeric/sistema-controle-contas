CREATE TABLE TRANSACAO	
(
    NU_TRANSACAO_ID BIGINT not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),  
	DT_TRANSACAO			TIMESTAMP,
	CD_APORTE				VARCHAR(50) DEFAULT NULL,
);



CREATE TABLE PESSOA_JURIDICA	
(
	PESSOA_JURIDICA_ID INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	RAZAO_SOCIAL		VARCHAR(40),
	NOME_FANTASIA		VARCHAR(40),
	CNPJ				VARCHAR(40)
);

CREATE TABLE PESSOA_FISICA
(
	PESSOA_FISICA_ID 	INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	NOME_COMPLETO		VARCHAR(40),
	CPF					VARCHAR(40),
	DT_NASCIMENTO		TIMESTAMP
);

CREATE TABLE CONTA_PESSOA
(
	CONTA_PESSOA_ID 	INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	PESSOA_FISICA_ID    INTEGER,
	PESSOA_JURIDICA_ID  INTEGER
	
);

CREATE TABLE CONTA	
(
	CONTA_ID 				INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	NOME					VARCHAR(40),
	CONTA_PAI_ID 			INTEGER,
	CONTA_PAI_MATRIZ_ID 	INTEGER,
	CONTA_PESSOA_ID			INTEGER,
	TP_PESSOA 				CHAR(1) CONSTRAINT TP_PESSOA_CONSTRAINT CHECK (TP_PESSOA IN ('F', 'J')), -- F - FISICA;  J - JURIDICO; 
	DT_CRIACAO				TIMESTAMP,
	STATUS					CHAR(1),
	CONSTRAINT CONTA_PAI_ID_fk FOREIGN KEY (CONTA_PAI_ID) REFERENCES CONTA(CONTA_ID),
	CONSTRAINT CONTA_PAI_MATRIZ_ID_fk FOREIGN KEY (CONTA_PAI_MATRIZ_ID) REFERENCES CONTA(CONTA_ID),
	CONSTRAINT CONTA_PESSOA_ID_fk FOREIGN KEY (CONTA_PESSOA_ID) REFERENCES CONTA_PESSOA(CONTA_PESSOA_ID)
);

CREATE TABLE SALDO
(
	SALDO_ID				INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	CONTA_ID				INTEGER,
	SALDO					NUMERIC(12, 2),
	DH_ATUALIZACAO			TIMESTAMP,
	CONSTRAINT CONTA_ID_fk FOREIGN KEY (CONTA_ID) REFERENCES CONTA(CONTA_ID)
);

CREATE TABLE OPERACAO	
(
	NU_OPERACAO_ID INTEGER not null primary key         GENERATED ALWAYS AS IDENTITY         (START WITH 1, INCREMENT BY 1),
	NU_TRANSACAO_ID		BIGINT,
	CD_STATUS_OPERACAO	VARCHAR(2),
	CD_TIPO_OPERACAO	NUMERIC(1, 0) CONSTRAINT CD_TIPO_OPERACAO_CONSTRAINT CHECK (CD_TIPO_OPERACAO IN (1,2,3)),  --0 - "Transferencia"; 1 - Aporte; '2' - Estorno
	DT_OPERACAO			TIMESTAMP,
	VL_OPERACAO			NUMERIC(12, 2),
	CONTA_ORIGEM_ID		INTEGER,	
	CONTA_DESTINO_ID		INTEGER,
	CONSTRAINT NU_TRANSACAO_ID_fk FOREIGN KEY (NU_TRANSACAO_ID) REFERENCES TRANSACAO(NU_TRANSACAO_ID),
	CONSTRAINT CONTA_ORIGEM_ID_fk FOREIGN KEY (CONTA_ORIGEM_ID) REFERENCES CONTA(CONTA_ID),
	CONSTRAINT CONTA_DESTINO_ID_fk FOREIGN KEY (CONTA_DESTINO_ID) REFERENCES CONTA(CONTA_ID)
);


