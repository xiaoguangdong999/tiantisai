 //控制层 
app.controller('infoController' ,function($scope,$controller ,uploadService,infoService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		infoService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		infoService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		infoService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=infoService.update( $scope.entity ); //修改  
		}else{
			serviceObject=infoService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		infoService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		infoService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	//上传图片
	$scope.uploadFile=function(){
		uploadService.uploadFile().success(
			function(response){
				if(response.success){
					$scope.image_entity= response.message;
					$scope.entity.imgurl = response.message;
				}else{
					alert(response.message);
				}
			}
		);


	}

	$scope.infoList1 = infoList;

	$scope.changeList1 = function (select1) {
		$scope.infoList = select1.child;

	}

	$scope.changeList = function (select1) {
		$scope.entity.name = select1.id;
		$scope.entity.num = select1.name;

	}

	$scope.guaninfo1 = function (select1) {
		if (select1.role=="T1-计算机网络工程") {
			$scope.searchEntity.num = "V";
		}
		if (select1.role=="T2-软件工程") {
			$scope.searchEntity.num = "W";
		}
		if (select1.role=="T3-物联网") {
			$scope.searchEntity.num = "X";
		}
		if (select1.role=="T4-晋城软工") {
			$scope.searchEntity.num = "Y";
		}
		if (select1.role=="T5-晋城数媒") {
			$scope.searchEntity.num = "Z";
		}

		$scope.infoList = select1.child;

	}

	$scope.guaninfo2 = function (select1) {
		$scope.searchEntity.name = select1.id;


	}

	//新建
	$scope.xinjian = function () {
		$scope.entity={};
		//$scope.entity.date=new Date();
		$scope.image_entity={};$scope.select1={};$scope.select2={};
	}




});	
