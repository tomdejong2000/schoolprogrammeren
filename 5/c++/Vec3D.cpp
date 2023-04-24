#include <iostream>
#include <vector>
#include "Classes.hpp"

namespace st = std;

Vec3D::Vec3D(float x,float y,float z):
    x (x), y (y), z (z){}

void Vec3D::show(st::string label){
    st::cout << label;
    st::cout << "(" << x <<"  " << y << "  " << z << ")" << '\n';
}
void Vec3D::show(st::string label, float scalar){
    st::cout << label << " ";
    st::cout << scalar << '\n';
}
void Vec3D::show(){
    st::cout<<'\n';
}

//add 2 3dvectors up with eachother
Vec3D Vec3D::add (Vec3D const &other){
    float _x= x+other.x;
    float _y= y+other.y;
    float _z= z+other.z;
    return Vec3D{_x,_y,_z};
}

//- 2 3dvectors with eachother
Vec3D Vec3D::sub (Vec3D const &other){
    float _x= x-other.x;
    float _y= y-other.y;
    float _z= z-other.z;
    return Vec3D{_x,_y,_z};
}

//multiply 3dvector with scalar
Vec3D Vec3D::mul (float scalar){
    float _x= x*scalar;
    float _y= y*scalar;
    float _z= z*scalar;
    return Vec3D{_x,_y,_z};
}

//reverse the 3dvector
Vec3D Vec3D::minus (){
    return mul(-1);
}

//devide the 3dvector with a scalar
Vec3D Vec3D::div(float scalar){
    float _x= x/scalar;
    float _y= y/scalar;
    float _z= z/scalar;
    return Vec3D{_x,_y,_z};
}

// length is sqrt of x^2 + y^2 + z^2
float Vec3D::norm (){
    return sqrt(pow(x,2)+pow(y,2)+pow(z,2)); 
}

//div 3dvector by the length
Vec3D Vec3D::unit (){
    return div(norm());                     
}

//https://en.wikipedia.org/wiki/Dot_product
float Vec3D::dot (Vec3D const &other){
    return ((x*other.x)+(y*other.y)+(z*other.z));
    
}

//https://en.wikipedia.org/wiki/Cross_product
Vec3D Vec3D::cross (Vec3D const &other){
    float _x = (y*other.z)-(z*other.y);
    float _y = (z*other.x)-(x*other.z);
    float _z = (x*other.y)-(y*other.x);
    return Vec3D{_x,_y,_z};
    
}