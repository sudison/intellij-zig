const Foo = struct {foo:i32};
const Point = struct {x:i32, foo: Foo};
const p = Point {.x = 1};
fn a() {const v = p.f