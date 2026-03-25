JFLAGS = -d classes -sourcepath src

.PHONY: all classes docs jar tests runtests clean

all: classes

classes:
	@mkdir -p classes
	javac $(JFLAGS) $$(find src -name "*.java")


docs:
	@mkdir -p docs
	javadoc -d docs -sourcepath src -subpackages game


jar: classes
	jar cfe livrable4a.jar game.Livrable4aMain -C classes .
	jar cfe livrable4b.jar game.Livrable4bMain -C classes .

tests:
	javac -classpath junit-console.jar:classes $$(find tests -name "*.java") -d classes/tests 

runtests: tests
	java -jar junit-console.jar -classpath classes/tests:classes -scan-classpath


execjar4aEx : 
	java -jar livrable4a.jar 10 10 5 

execjar4bEx : 
	java -jar livrable4b.jar 10 10 5 10

clean:
	rm -rf classes/*
	rm -rf docs/*
	rm -f livrable3a.jar livrable4b.jar

