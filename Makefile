
OUT_DIR = out/production/avaj-launcher
SCENARIO_DIR = scenarios
FILE = scenario.txt

all: build

build:
	find -name "*.java" > sources.txt
	javac @sources.txt -d $(OUT_DIR)

run:
	java -cp $(OUT_DIR) Simulator $(SCENARIO_DIR)/$(FILE)

clean:
	rm -rf out/
	rm -f sources.txt

re: clean all