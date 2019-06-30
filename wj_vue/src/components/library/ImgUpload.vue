<template>
    <div>
        <el-upload action="http://localhost:8443/api/covers"
            class="img-upload"
            ref="upload"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :on-success="handleSuccess"
            :before-remove="beforeRemove"
            multiple 
            :limit="1"
            :on-exceed="hanleExceed"
            :file-list="fileList">
          <el-button type="primary" size="small">点击上传</el-button>
          <div slot="tip" class="el-upload_tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
    </div>
</template>

<script>
export default {
    name: 'ImgUpload',
    data () {
        return {
            fileList: [],
            url: ''
        }
    },
    methods: {
        handleRemove(file, fileList) {
            console.log(file, fileList)
        },

        handlePreview(file) {
            console.log(file)
        },

        handleExceed(files, fileList) {
            this.$message.warning('当前限制选择一个文件，本次选择了${files.length}个文件，共选择了${files.length + fileList.length}个文件')
        },

        beforeRemove(file, fileList) {
            return this.$confirm('确定移除${file.name}?')
        },

        handleSuccess(response) {
            this.url = response
            this.$emit('onUpload')
            this.$message.warning('上传成功')
        },

        clear() {
            this.$refs.upload.clearFiles()
        }
    },
}
</script>