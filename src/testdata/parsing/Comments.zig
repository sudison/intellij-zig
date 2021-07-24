fn foo() void {}
fn main() void {
   var a =
    var a = foo();
    var b = a.b.c();
    if (true) {
      var b = 1;
      {
        var c = 1;
        var d = {return 1;};
      }
    }
    s.x.y
}
pub const s = struct {
        pub const Node = struct {
            prev: ?*Node,
            next: ?*Node,
            data: T,
        };

        first: ?*Node,
        last:  ?*Node,
        len:   usize,
    };

const ss = s {.first = null, .last = null};