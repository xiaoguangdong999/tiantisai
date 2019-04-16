//服务层
app.service('infoService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../info/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../info/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../info/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../info/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../info/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../info/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../info/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.searchAve = function (page,rows,searchEntity) {
		return $http.post('/info/searchGroupAve?page='+page+"&rows="+rows, searchEntity);
	}
});
