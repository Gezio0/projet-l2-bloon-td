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
	jar cfe livrable3a.jar game.Livrable3aMain -C classes .
	jar cfe livrable3b.jar game.Livrable3bMain -C classes .

tests:
	@echo "a faire"

runtests:
	@echo "a faire"


clean:
	rm -rf classes/*
	rm -rf docs/*
	rm -f livrable3a.jar livrable3b.jar