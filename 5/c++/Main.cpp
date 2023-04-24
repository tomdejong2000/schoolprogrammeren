#include "Classes.hpp"

/*
& = memory adress / reference to an object 
* = stores the adress of a pointer, when called with *will use the original memory and also modify the original


Requirements:
3 floating spheres in the sky above a chessboard using rayscanning and characters in commandline


Testspecs:
visual test: there should be 3 spheres in the sky above a chessboard visible
when zooming in each character should be visible



Design:


    A data structure to save the image. (vec3d)
    the vec3d has rows of vectors of floats
    

the 3D vector:
    class called Vec3D
    3 coordinates xyz
    have to be able to do the following calculations: add,sub,mul,minus,div,norm,unit,dot,cross
    https://en.wikipedia.org/wiki/Vector_(mathematics_and_physics)#Miscellaneous

Object:
    parents class of all objects
    center point and hit class

sphere:
    inherit object
    It has a center and radius
    The function calculates the distance from a ray and whether it hits or not, if so it also calculates where it hits
    when the rays hits it also changes the ray to the reflected ray
floor:
    inherit object
    the floor has a center and decides if a ray hits a white or black square
    the black square acts like a hole in the floor
    none of the rays reflect

ray:
    support(origin) and direction
    returns if it hits something or not

rayscanner:
    the rayscanner "shoots" rays from the eye (support vector) to every point on the screen
    then calls the scan function for every ray it "shoots" and changes the brightness of that pixel
    prints the final image 
    scan()
    render()
*/

namespace st = std;

int main(){
    auto objects = VPO();


    Sphere *sphere1 = new Sphere(500, 2000, 150, 110); //medium  sphere
    Sphere *sphere2 = new Sphere(100, 3000, 220, 200);  //big  sphere
    Sphere *sphere3 = new Sphere(-200, 1300, 200, 30);  //small sphere
    Floor *vloer = new Floor(0,0,0);                    //floor
    objects.push_back(sphere1);
    objects.push_back(sphere2);
    objects.push_back(sphere3);
    objects.push_back(vloer);
    RayScanner scanner = RayScanner(objects);
    scanner.scan();
    scanner.render();
    return 0;
}