cc = g++
prom = stl
deps = *.h
src = *.cpp
obj = $(src:%.c=%.o)

$(prom): $(obj)
	$(cc) -o $(prom) $(obj)

%.o: %.c $(deps)
	$(cc) -c $< -o $@

clean:
	rm -rf $(obj) $(prom)