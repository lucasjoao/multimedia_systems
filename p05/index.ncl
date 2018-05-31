<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="connectorBase1">
			<causalConnector id="onBeginStart">
				<simpleAction max="unbounded" qualifier="par" role="start">
				</simpleAction>
				<simpleCondition role="onBegin">
				</simpleCondition>
			</causalConnector>
			<causalConnector id="onEndStart">
				<simpleAction qualifier="par" role="start">
				</simpleAction>
				<simpleCondition role="onEnd">
				</simpleCondition>
			</causalConnector>
		</connectorBase>
		<descriptorBase id="descriptorBase1">
			<descriptor id="dr1" region="r1">
			</descriptor>
			<descriptor id="dr2" region="r2">
			</descriptor>
			<descriptor id="dr3" region="r3">
			</descriptor>
		</descriptorBase>
		<regionBase id="regionBase1">
			<region height="100.00%" id="rgTV" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="60.00%" id="r1" left="10.00%" top="10.00%" width="35.00%" zIndex="2">
				</region>
				<region height="60.00%" id="r2" left="55.00%" top="10.00%" width="35.00%" zIndex="2">
				</region>
				<region height="10.00%" id="r3" left="10.00%" top="80.00%" width="80.00%" zIndex="2">
				</region>
			</region>
		</regionBase>
	</head>
	<body id="myBodyID">
		<media descriptor="dr1" id="video1" src="media/video1.mpg" type="video/mpeg">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<media descriptor="dr1" id="video2" src="media/video2.mpg" type="video/mpeg">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<media descriptor="dr2" id="imagem1" src="media/imagem1.jpg" type="image/jpeg">
			<property name="explicitDur" value="8s">
			</property>
		</media>
		<media descriptor="dr2" id="imagem2" src="media/imagem2.gif" type="image/gif">
			<property name="explicitDur" value="12s">
			</property>
		</media>
		<media descriptor="dr3" id="legenda1" src="media/legenda1.htm" type="text/html">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<media descriptor="dr3" id="legenda2" src="media/legenda2.htm" type="text/html">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<media id="audio1" src="media/audio1.mp3" type="audio/mp3">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<media id="audio2" src="media/audio2.mp3" type="audio/mp3">
			<property name="explicitDur" value="10s">
			</property>
		</media>
		<port component="video1" id="port1"/>
		<port component="imagem1" id="port2"/>
		<port component="legenda1" id="port3"/>
		<port component="audio1" id="port4"/>
		<link id="link2" xconnector="onEndStart">
			<bind component="video1" role="onEnd"/>
			<bind component="video2" role="start"/>
		</link>
		<link id="link3" xconnector="onEndStart">
			<bind component="imagem1" role="onEnd"/>
			<bind component="imagem2" role="start"/>
		</link>
		<link id="link4" xconnector="onEndStart">
			<bind component="legenda1" role="onEnd"/>
			<bind component="legenda2" role="start"/>
		</link>
		<link id="link5" xconnector="onEndStart">
			<bind component="audio1" role="onEnd"/>
			<bind component="audio2" role="start"/>
		</link>
	</body>
</ncl>
