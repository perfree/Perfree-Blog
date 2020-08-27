(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["views-archive-archive-module"],{

/***/ "./src/app/views/archive/archive-routing.module.ts":
/*!*********************************************************!*\
  !*** ./src/app/views/archive/archive-routing.module.ts ***!
  \*********************************************************/
/*! exports provided: ArchiveRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ArchiveRoutingModule", function() { return ArchiveRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/_@angular_core@10.0.8@@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/_@angular_router@10.0.8@@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _archive_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./archive.component */ "./src/app/views/archive/archive.component.ts");





const routes = [
    { path: '', component: _archive_component__WEBPACK_IMPORTED_MODULE_2__["ArchiveComponent"] }
];
class ArchiveRoutingModule {
}
ArchiveRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: ArchiveRoutingModule });
ArchiveRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function ArchiveRoutingModule_Factory(t) { return new (t || ArchiveRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ArchiveRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ArchiveRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/views/archive/archive.component.ts":
/*!****************************************************!*\
  !*** ./src/app/views/archive/archive.component.ts ***!
  \****************************************************/
/*! exports provided: ArchiveComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ArchiveComponent", function() { return ArchiveComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/_@angular_core@10.0.8@@angular/core/__ivy_ngcc__/fesm2015/core.js");


class ArchiveComponent {
    constructor() { }
    ngOnInit() {
    }
}
ArchiveComponent.ɵfac = function ArchiveComponent_Factory(t) { return new (t || ArchiveComponent)(); };
ArchiveComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ArchiveComponent, selectors: [["app-archive"]], decls: 3, vars: 0, consts: [[1, "archive-box"], [1, "archive-title"]], template: function ArchiveComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\u5F53\u524D\u5DF2\u53D1\u5E0399\u7BC7\u6587\u7AE0");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, styles: [".archive-box[_ngcontent-%COMP%]{\r\n    background-color: white;\r\n    padding: 15px;\r\n}\r\n.archive-title[_ngcontent-%COMP%]{\r\n    height: 30px;\r\n    line-height: 30px;\r\n    margin-bottom: 10px;\r\n    font-size: 15px;\r\n    font-weight: 600;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdmlld3MvYXJjaGl2ZS9hcmNoaXZlLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSx1QkFBdUI7SUFDdkIsYUFBYTtBQUNqQjtBQUNBO0lBQ0ksWUFBWTtJQUNaLGlCQUFpQjtJQUNqQixtQkFBbUI7SUFDbkIsZUFBZTtJQUNmLGdCQUFnQjtBQUNwQiIsImZpbGUiOiJzcmMvYXBwL3ZpZXdzL2FyY2hpdmUvYXJjaGl2ZS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmFyY2hpdmUtYm94e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG59XHJcbi5hcmNoaXZlLXRpdGxle1xyXG4gICAgaGVpZ2h0OiAzMHB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDMwcHg7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAxMHB4O1xyXG4gICAgZm9udC1zaXplOiAxNXB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IDYwMDtcclxufSJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ArchiveComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-archive',
                templateUrl: './archive.component.html',
                styleUrls: ['./archive.component.css']
            }]
    }], function () { return []; }, null); })();


/***/ }),

/***/ "./src/app/views/archive/archive.module.ts":
/*!*************************************************!*\
  !*** ./src/app/views/archive/archive.module.ts ***!
  \*************************************************/
/*! exports provided: ArchiveModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ArchiveModule", function() { return ArchiveModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/_@angular_core@10.0.8@@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/_@angular_common@10.0.8@@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _archive_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./archive-routing.module */ "./src/app/views/archive/archive-routing.module.ts");
/* harmony import */ var _archive_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./archive.component */ "./src/app/views/archive/archive.component.ts");
/* harmony import */ var ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ng-zorro-antd */ "./node_modules/_ng-zorro-antd@9.3.0@ng-zorro-antd/__ivy_ngcc__/fesm2015/ng-zorro-antd.js");






class ArchiveModule {
}
ArchiveModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: ArchiveModule });
ArchiveModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function ArchiveModule_Factory(t) { return new (t || ArchiveModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__["NgZorroAntdModule"],
            _archive_routing_module__WEBPACK_IMPORTED_MODULE_2__["ArchiveRoutingModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](ArchiveModule, { declarations: [_archive_component__WEBPACK_IMPORTED_MODULE_3__["ArchiveComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__["NgZorroAntdModule"],
        _archive_routing_module__WEBPACK_IMPORTED_MODULE_2__["ArchiveRoutingModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ArchiveModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_archive_component__WEBPACK_IMPORTED_MODULE_3__["ArchiveComponent"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    ng_zorro_antd__WEBPACK_IMPORTED_MODULE_4__["NgZorroAntdModule"],
                    _archive_routing_module__WEBPACK_IMPORTED_MODULE_2__["ArchiveRoutingModule"]
                ]
            }]
    }], null, null); })();


/***/ })

}]);
//# sourceMappingURL=views-archive-archive-module.js.map