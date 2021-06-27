<template>
	<view>
		<image src="../../static/teach.png" @click="gopage(0)"></image>
		<image src="../../static/study.png" @click="gopage(1)"></image>
	</view>
</template>

<script>
	export default {
		data() {
			return {
			}
		},
		methods: {
			gopage(e){
				if (e){
					uni.navigateTo({
						url: "../study/study"
					});
				}else{
					uni.navigateTo({
						url: "../teach/teach"
					});
				}
			}
		}
	}
</script>

<style>

</style>
