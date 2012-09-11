(function($){
	/*******************************
         * @name Placeholder跨浏览器兼容插件 v1.0
	 * @author norion
	 * @author blog http://zkeyword.com/
	 * @2012.04.15
	 * @可自由转载及使用,但请注明版权归属
	 *******************************/
	$.fn.placeholder = function(){
		var searchText = this;
		var searchValue = searchText.attr('placeholder');
		if ( !( 'placeholder' in document.createElement('input') ) ){
			searchText.removeAttr('placeholder').val(searchValue).bind('focus',function(){
				if ( this.value==searchValue) {this.value=''; };
			}).bind('blur',function(){
				if ( this.value=='' ){ this.value=searchValue; };
			});
		}else{
			searchText.bind('focus',function(){
				if ( jQuery(this).attr('placeholder') == searchValue ){ jQuery(this).attr('placeholder','') };
			}).bind('blur',function(){
				if ( jQuery(this).attr('placeholder','') ){ jQuery(this).attr('placeholder',searchValue) };
			});
		}
	}
})(jQuery);