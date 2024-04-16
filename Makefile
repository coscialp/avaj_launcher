
OUT_DIR = out/production/avaj-launcher
FILE = scenarios/scenario.txt

all: build

build:
	find -name "*.java" > sources.txt
	javac @sources.txt -d $(OUT_DIR)

run:
	java -cp $(OUT_DIR) com.avaj_launcher.Simulator $(FILE)

clean:
	rm -rf out/
	rm -f sources.txt

re: clean all

rerun: re run