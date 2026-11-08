import deps.Proxy;

void main(String... args) {
    var data = Stream.of(args).mapToInt(Integer::parseInt).toArray();
    Proxy.serve(data);
}
